package com.account_manager.apply_system.repository

import com.account_manager.apply_system.model.User

interface UserRepository {
    fun find(id: String): User?
}