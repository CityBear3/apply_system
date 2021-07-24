package com.account_manager.apply_system.service

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class UserInfoService {
    fun getUserInfo(): ApplyUserDetail {
        return SecurityContextHolder.getContext().authentication.principal as ApplyUserDetail
    }
}