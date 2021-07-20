package com.account_manager.apply_system.controller

import com.account_manager.apply_system.service.UserDeleterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class UserDeleterController(private val userDeleterService: UserDeleterService) {
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<String> {
        return userDeleterService.userDeleter(id)
    }
}