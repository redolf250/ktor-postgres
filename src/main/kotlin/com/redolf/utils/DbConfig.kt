package com.redolf.utils

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig


fun hikariConfig(config: HikariConfig): HikariConfig {
    val configFactory = ConfigFactory.load()
    config.dataSourceClassName =configFactory.getConfig("datasource").getString("dataSourceClassName")

    config.maximumPoolSize = configFactory.getConfig("datasource").getInt("maximumPoolSize")
    config.isAutoCommit = configFactory.getConfig("datasource").getBoolean("isAutoCommit")
    config.transactionIsolation = configFactory.getConfig("datasource").getString("transactionIsolation")
//    config.driverClassName = configFactory.getConfig("datasource").getString("driverClassName")
//    config.jdbcUrl =  configFactory.getConfig("datasource").getString("jdbcUrl")
    config.username = configFactory.getConfig("datasource").getString("username")
    config.password = configFactory.getConfig("datasource").getString("password")
    config.validate()
    return config
}