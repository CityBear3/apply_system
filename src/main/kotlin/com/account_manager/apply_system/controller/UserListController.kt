package com.account_manager.apply_system.controller

import com.account_manager.apply_system.model.UserInfoModel
import com.account_manager.apply_system.service.UserListService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin")
class UserListController(private val userListService: UserListService) {
    @GetMapping("/user/list")
    fun list(): ResponseEntity<MutableList<UserInfoModel>?> = userListService.getUserList()
}