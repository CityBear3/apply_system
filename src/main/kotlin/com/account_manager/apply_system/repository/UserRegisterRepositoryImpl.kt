package com.account_manager.apply_system.repository

import com.account_manager.apply_system.CreateConnection
import com.account_manager.apply_system.model.UserTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRegisterRepositoryImpl(private val connector: CreateConnection) : UserRegisterRepository {
    override fun register(userid: String, username: String, userpassword: String, userrole: String): Boolean {
        connector.connection()
        return kotlin.runCatching {
            transaction {
                val user = UserTable.insert {
                    it[id] = userid
                    it[name] = username
                    it[password] = BCryptPasswordEncoder().encode(userpassword)
                    it[role] = userrole
                }
            }
        }.fold(
            onSuccess = { return@fold true },
            onFailure = { return@fold false }
        )
    }
}