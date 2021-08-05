package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.OrderInfoModel
import com.account_manager.apply_system.model.RequestModel
import com.account_manager.apply_system.repository.OrderRequestRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OrderReceiveService(
    private val orderRequestRepository: OrderRequestRepository,
    private val userInfoService: UserInfoService
) {
    fun receiveOrder(requestModel: RequestModel): ResponseEntity<String> {
        val orderInfoModel = OrderInfoModel(
            userInfoService.getUserInfo().id,
            requestModel.product,
            requestModel.propose,
            requestModel.reason
        )

        val result = orderRequestRepository.receiveRequest(orderInfoModel)
        return if (result) {
            ResponseEntity("Your order request is received", HttpStatus.OK)
        } else {
            ResponseEntity("Your order request cannot be received", HttpStatus.BAD_REQUEST)
        }
    }
}
