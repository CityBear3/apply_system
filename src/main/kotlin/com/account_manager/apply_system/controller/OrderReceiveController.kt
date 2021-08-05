package com.account_manager.apply_system.controller

import com.account_manager.apply_system.model.RequestModel
import com.account_manager.apply_system.service.OrderReceiveService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderReceiveController(private val orderReceiveService: OrderReceiveService) {
    @PostMapping("/order")
    fun order(@RequestBody request: RequestModel): ResponseEntity<String> = orderReceiveService.receiveOrder(request)
}