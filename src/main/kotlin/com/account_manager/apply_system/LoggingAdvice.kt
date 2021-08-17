package com.account_manager.apply_system

import com.account_manager.apply_system.service.ApplyUserDetail
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class LoggingAdvice {
    private val logger = LoggerFactory.getLogger(LoggingAdvice::class.java)

    @Before("execution(* com.account_manager.apply_system.controller.*.*(..))")
    fun beforeLogging(joinPoint: JoinPoint) {
        val userInfo = SecurityContextHolder.getContext().authentication.principal as ApplyUserDetail
        logger.info("Start: ${joinPoint.signature} userId=${userInfo.id}")
        logger.info("Class: ${joinPoint.target.javaClass}")
        logger.info("Session: ${(RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request.session.id}")
    }

    @After("execution(* com.account_manager.apply_system.controller.*.*(..))")
    fun afterLogging(joinPoint: JoinPoint) {
        val userInfo = SecurityContextHolder.getContext().authentication.principal as ApplyUserDetail
        logger.info("End: ${joinPoint.signature} userId=${userInfo.id}")
    }
}