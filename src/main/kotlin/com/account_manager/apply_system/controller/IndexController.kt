package com.account_manager.apply_system.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {
    @GetMapping("/")
    fun index(): String = "RCC Apply Management System"
}

