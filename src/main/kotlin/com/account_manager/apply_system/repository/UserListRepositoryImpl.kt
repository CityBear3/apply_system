package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.UserInfoModel
import com.account_manager.apply_system.model.UserTable
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserListRepositoryImpl(private val connector: CreateConnection) : UserListRepository {
    override fun viewAll(): MutableList<UserInfoModel> {
        val list = mutableListOf<UserInfoModel>()
        return kotlin.runCatching {
            connector.connection()
            transaction {
                addLogger(StdOutSqlLogger)
                val userInfo = UserTable.selectAll()
                userInfo.map {
                    val info = UserInfoModel(it[UserTable.id], it[UserTable.name])
                    list.add(info)
                }
            }
        }.fold (
            onSuccess = {return@fold list},
            onFailure = {
                val info = UserInfoModel(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Failed to get user list.")
                return@fold mutableListOf<UserInfoModel>(info)
            }
        )
    }
}