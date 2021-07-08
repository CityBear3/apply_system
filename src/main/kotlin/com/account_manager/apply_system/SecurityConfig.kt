package com.account_manager.apply_system

import com.account_manager.apply_system.handler.DeniedHandler
import com.account_manager.apply_system.handler.EntryPointHandler
import com.account_manager.apply_system.handler.FailureHandler
import com.account_manager.apply_system.handler.SuccessHandler
import com.account_manager.apply_system.model.RoleType
import com.account_manager.apply_system.service.AuthenticationService
import com.account_manager.apply_system.service.DetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@EnableWebSecurity
class SecurityConfig(private val authenticationService: AuthenticationService) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers("/login").permitAll()
            .mvcMatchers("/").permitAll()
            .mvcMatchers("/admin/**").hasAnyAuthority(RoleType.ADMIN.toString())
            .anyRequest().authenticated()
            .and()
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .usernameParameter("id")
            .passwordParameter("password")
            .successHandler(SuccessHandler())
            .failureHandler(FailureHandler())
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(EntryPointHandler())
            .accessDeniedHandler(DeniedHandler())
            //.and()
            //.cors()
            //.configurationSource(corsConfigurationSource())
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(DetailsService(authenticationService)).passwordEncoder(BCryptPasswordEncoder())
    }
}