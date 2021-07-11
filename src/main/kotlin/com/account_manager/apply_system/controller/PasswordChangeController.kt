package com.account_manager.apply_system.controller

import com.account_manager.apply_system.model.NewUserInfoModel
import com.account_manager.apply_system.service.PasswordChangeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PasswordChangeController(private val passwordChangeService: PasswordChangeService) {
    @PostMapping("change")
    fun change(@RequestBody request: NewUserInfoModel): ResponseEntity<String> {
        return passwordChangeService.passwordChange(request)
    }
}