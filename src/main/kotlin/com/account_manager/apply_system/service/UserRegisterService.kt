package com.account_manager.apply_system.service

import com.account_manager.apply_system.repository.UserRegisterRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserRegisterService(private val userRegisterRepository: UserRegisterRepository) {
    fun userRegister(id: String, name: String, password: String, role: String): ResponseEntity<String> {
        val check = userRegisterRepository.register(id, name, password, role)
        return if (check) {
            ResponseEntity("Succeed to registration", HttpStatus.OK)
        } else {
            ResponseEntity("Failed to registration", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}