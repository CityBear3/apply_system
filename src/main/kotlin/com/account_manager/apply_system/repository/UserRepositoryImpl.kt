package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.User
import com.account_manager.apply_system.model.UserTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRepositoryImpl() : UserRepository {
    override fun find(id: String): User? {
        CreateConnection().connection()
        return transaction {
            val record = UserTable.select { UserTable.id eq id }.single()
            return@transaction toUser(record)
        }
    }

    private fun toUser(record: ResultRow): User {
        return User(
            record[UserTable.id],
            record[UserTable.name],
            record[UserTable.password],
            record[UserTable.role]
        )
    }
}