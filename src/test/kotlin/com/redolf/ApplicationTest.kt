package com.redolf

import com.redolf.db.DatabaseFactory
import com.redolf.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.jetbrains.exposed.sql.Database
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
            DatabaseFactory.init()
        }

        client.get("/api/v1/countries").apply {
            assertEquals(HttpStatusCode.OK, status)
        }

        client.get("/api/v1/countries/1").apply {
            assertEquals(HttpStatusCode.Found, status)
        }.run {
            print("")
        }

        client.get("/api/v1/countries/6").apply {
            assertEquals(HttpStatusCode.NotFound, status)
        }
    }
}
