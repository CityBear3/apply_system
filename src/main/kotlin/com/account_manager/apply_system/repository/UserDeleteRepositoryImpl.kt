package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.UserTable
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserDeleteRepositoryImpl(private val connector: CreateConnection) : UserDeleteRepository {
    override fun deleter(userID: String): Boolean {
        return kotlin.runCatching {
            connector.connection()
            transaction {
                addLogger(StdOutSqlLogger)
                UserTable.deleteWhere { UserTable.id eq userID }
            }
        }.fold(
            onSuccess = { return@fold true },
            onFailure = { return@fold false }
        )
    }
}