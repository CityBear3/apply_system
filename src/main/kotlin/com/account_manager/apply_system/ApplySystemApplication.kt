package com.account_manager.apply_system

import com.account_manager.apply_system.model.RoleType
import com.account_manager.apply_system.model.UserTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.management.relation.Role

@SpringBootApplication
class ApplySystemApplication

fun main(args: Array<String>) {

	CreateConnection().connection()
	transaction {
		addLogger(StdOutSqlLogger)
		val record = UserTable.select { UserTable.id eq "ex1234" }.single()
		println(record[UserTable.name])
	}

	runApplication<ApplySystemApplication>(*args)
}
