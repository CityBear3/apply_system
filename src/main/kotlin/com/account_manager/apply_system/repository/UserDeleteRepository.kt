package com.account_manager.apply_system.repository

interface UserDeleteRepository {
    fun deleter(userID: String): Boolean
}