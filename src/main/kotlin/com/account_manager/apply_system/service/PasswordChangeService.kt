package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.NewUserInfoModel
import com.account_manager.apply_system.repository.PasswordChangeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class PasswordChangeService(private val passwordChangeRepository: PasswordChangeRepository) {
    fun passwordChange(newUserInfo: NewUserInfoModel): ResponseEntity<String> {
        if (newUserInfo.newPassword != newUserInfo.checkPassword) {
            return ResponseEntity("Your new password is different on both", HttpStatus.INTERNAL_SERVER_ERROR)
        }

        val userInfo = SecurityContextHolder.getContext().authentication.principal as ApplyUserDetail
        val result = passwordChangeRepository.changer(newUserInfo.newPassword, userInfo.id)
        return if (result) {
            ResponseEntity("Succeed to change password", HttpStatus.OK)
        } else {
            ResponseEntity("Failed to change password", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}