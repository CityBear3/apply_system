package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class DetailsService(private val authenticationService: AuthenticationService) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = authenticationService.findUser(username!!)
        return user?.let { ApplyUserDetail(user) }
    }
}

data class ApplyUserDetail(val id: String, val name: String, val pass: String, val role: String) : UserDetails {
    constructor(user: User) : this(user.id, user.name, user.password, user.role)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.role)
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.id
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}