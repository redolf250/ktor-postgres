package com.redolf.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Country : Table("tbl_countries") {
    val id = integer("id").autoIncrement()
    val name = varchar("name",30)
    val continent = varchar("continent",30)
    val population = integer("population")
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}