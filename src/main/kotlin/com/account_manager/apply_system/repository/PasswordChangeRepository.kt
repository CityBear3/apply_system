package com.account_manager.apply_system.repository

interface PasswordChangeRepository {
    fun changer(newPassword: String): Boolean
}