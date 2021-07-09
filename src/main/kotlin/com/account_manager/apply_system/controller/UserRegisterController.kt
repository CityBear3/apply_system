package com.account_manager.apply_system.controller

import com.account_manager.apply_system.model.UserRegisterModel
import com.account_manager.apply_system.service.UserRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class UserRegisterController(private val userRegisterService: UserRegisterService) {
    @PostMapping("/registration")
    fun registration(@RequestBody request: UserRegisterModel):  ResponseEntity<String> {
        return userRegisterService.userRegister(request.id, request.name, request.password, request.role)
    }
}