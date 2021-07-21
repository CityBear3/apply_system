package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.UserInfoModel
import com.account_manager.apply_system.repository.UserListRepository
import org.springframework.stereotype.Service

@Service
class UserListService(private val userListRepository: UserListRepository) {
    fun getUserList(): MutableList<UserInfoModel> {
        return userListRepository.viewAll()
    }
}