package com.account_manager.apply_system.repository

import com.account_manager.apply_system.model.UserInfoModel

interface UserListRepository {
    fun viewAll(): MutableList<UserInfoModel>
}