package com.account_manager.apply_system.model

import org.jetbrains.annotations.NotNull
import org.jetbrains.exposed.sql.Table

object RequestTable : Table("request") {
    val id = integer("id").autoIncrement()
    @NotNull
    val userID = varchar("userid", 16)
    @NotNull
    val product = varchar("product", 256)
    @NotNull
    val propose = varchar("propose", 32)
    @NotNull
    val reason = varchar("reason", 256)
}