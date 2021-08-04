package com.account_manager.apply_system.initialize

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class UserInitializeConfig(
    private val userInitializeTasklet: UserInitializeTasklet,
    private val stepBuilderFactory: StepBuilderFactory,
    private val jobBuilderFactory: JobBuilderFactory
) {
    @Bean
    fun job(): Job = jobBuilderFactory.get("initialization").start(step()).build()

    @Bean
    fun step(): Step = stepBuilderFactory.get("createUser").tasklet(userInitializeTasklet).build()
}