package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.OrderInfoModel
import com.account_manager.apply_system.model.RequestTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class OrderRequestRepositoryImpl(private val createConnection: CreateConnection) : OrderRequestRepository {
    override fun receiveRequest(orderInfoModel: OrderInfoModel): Boolean {
        return kotlin.runCatching {
            createConnection.connection()
            transaction {
                RequestTable.insert {
                    it[userID] = orderInfoModel.userID
                    it[product] = orderInfoModel.product
                    it[propose] = orderInfoModel.propose
                    it[reason] = orderInfoModel.reason
                }
            }
        }.fold(
            onFailure = { return@fold false },
            onSuccess = { return@fold true }
        )
    }
}