package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.User
import com.account_manager.apply_system.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val userRepository: UserRepository) {
    fun findUser(id: String): User? {
        return userRepository.find(id)
    }
}