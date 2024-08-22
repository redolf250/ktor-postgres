package com.redolf

import com.redolf.db.DatabaseFactory
import com.redolf.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8090, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    configureSecurity()
//    println(environment.config.property("datasource.username").getString())
    configureSerialization()
//    configureDatabases()
    DatabaseFactory.init()
    configureHTTP()
    configureMonitoring()
    configureRouting()
}

fun Application.m(){
//    environment.config.property("datasource.username")
}