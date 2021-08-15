package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.UserInfoModel
import com.account_manager.apply_system.repository.UserListRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserListService(private val userListRepository: UserListRepository) {
    fun getUserList(): ResponseEntity<MutableList<UserInfoModel>?> {
        val userList = userListRepository.viewAll()
        return if (userList != null) {
            ResponseEntity(userList, HttpStatus.OK)
        } else {
            ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}