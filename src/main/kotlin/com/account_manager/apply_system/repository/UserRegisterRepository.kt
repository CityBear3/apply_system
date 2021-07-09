package com.account_manager.apply_system.repository

import org.springframework.http.HttpStatus

interface UserRegisterRepository {
    fun register(id: String, name: String, password: String, role: String): Boolean
}