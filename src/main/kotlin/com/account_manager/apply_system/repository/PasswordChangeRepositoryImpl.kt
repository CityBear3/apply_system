package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.UserTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class PasswordChangeRepositoryImpl(private val connector: CreateConnection) : PasswordChangeRepository {
    override fun changer(newPassword: String, userID: String): Boolean {
        return kotlin.runCatching {
            connector.connection()
            transaction {
                UserTable.update({ UserTable.id eq userID }) {
                    it[password] = BCryptPasswordEncoder().encode(newPassword)
                }
            }
        }.fold(
            onSuccess = { return@fold true },
            onFailure = { return@fold false }
        )
    }
}