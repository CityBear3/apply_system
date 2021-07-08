package com.account_manager.apply_system.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
    @GetMapping("/demo")
    fun demo(): DemoData {
        return DemoData(greet = "Hello")
    }
}

data class DemoData(val greet: String)