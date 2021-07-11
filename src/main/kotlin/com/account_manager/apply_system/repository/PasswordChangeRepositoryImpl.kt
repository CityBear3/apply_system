package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.UserTable
import com.account_manager.apply_system.service.ApplyUserDetail
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class PasswordChangeRepositoryImpl(private val connector: CreateConnection) : PasswordChangeRepository {
    override fun changer(newPassword: String): Boolean {
        return kotlin.runCatching {
            val userInfo = SecurityContextHolder.getContext().authentication.principal as ApplyUserDetail
            connector.connection()
            transaction {
                UserTable.update({ UserTable.id eq userInfo.id }) {
                    it[password] = BCryptPasswordEncoder().encode(newPassword)
                }
            }
        }.fold(
            onSuccess = { return@fold true },
            onFailure = { return@fold false }
        )
    }
}