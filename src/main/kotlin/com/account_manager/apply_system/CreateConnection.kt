package com.account_manager.apply_system

import org.jetbrains.exposed.sql.Database
import org.springframework.stereotype.Repository

@Repository
class CreateConnection {
    fun connection() {
        Database.connect(
            url = "jdbc:mysql://127.0.0.1:53306/webapp",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "mysql"
        )
    }
}