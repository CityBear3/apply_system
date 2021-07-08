package com.account_manager.apply_system.model

import org.jetbrains.exposed.sql.Table

object UserTable: Table("users") {
    val id = varchar("id", 16)
    val name = varchar("name", 32)
    val password = varchar("password", 64)
    val role = varchar("role", 6)
}
