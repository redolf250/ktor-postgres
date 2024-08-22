package com.redolf.db

import com.redolf.models.Country
import com.redolf.models.User
import com.redolf.utils.hikariConfig
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init(){
        Database.connect(hikari())
        transaction {
            SchemaUtils.run {
                create(User)
                create(Country)
            }
        }
    }

    private fun hikari(): HikariDataSource {
//        val configFactory = ConfigFactory.load("hikari.properties")
//        println(configFactory.getString("dataSource.serverName"))
        val config = HikariConfig()
//        return HikariDataSource(config)
        return HikariDataSource(hikariConfig(config))
    }

    suspend fun <T> dbQuery (block: () -> T) : T = withContext(Dispatchers.IO){
        transaction {
            block()
        }
    }
}