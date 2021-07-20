package com.account_manager.apply_system.service

import com.account_manager.apply_system.repository.UserDeleteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserDeleterService(private val userDeleteRepository: UserDeleteRepository) {
    fun userDeleter(userID: String): ResponseEntity<String> {
        return if (userDeleteRepository.deleter(userID)) {
            ResponseEntity("Succeed to delete user", HttpStatus.OK)
        } else {
            ResponseEntity("Failed to delete user", HttpStatus.BAD_REQUEST)
        }
    }
}