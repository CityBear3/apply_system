package com.account_manager.apply_system.model

import org.jetbrains.annotations.NotNull
import org.jetbrains.exposed.sql.Table

object UserTable: Table("users") {
    @NotNull
    val id = varchar("id", 16)
    @NotNull
    val name = varchar("name", 32)
    @NotNull
    val password = varchar("password", 64)
    @NotNull
    val role = varchar("role", 6)
}
