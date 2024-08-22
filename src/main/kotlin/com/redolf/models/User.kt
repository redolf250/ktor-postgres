package com.redolf.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime


object User : Table("tbl_users") {
    private val id = integer("id").autoIncrement()
    val fullName = varchar("fullName",30)
    val lastName = varchar("lastName",30)
    val username = varchar("userName",30)
    val email= varchar("email",30)
    val password = text("password")
    val createdAt = datetime("createdAt").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}