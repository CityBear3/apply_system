package com.account_manager.apply_system.repository

import com.account_manager.apply_system.model.OrderInfoModel


interface OrderRequestRepository {
    fun receiveRequest(orderInfoModel: OrderInfoModel): Boolean
}