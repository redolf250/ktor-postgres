package com.redolf.utils

import com.redolf.dto.Response
import io.ktor.http.*
import java.time.LocalDateTime

val message = "No country with such id found!!!"
val code = HttpStatusCode.NotFound.value
val timestamp = LocalDateTime.now().toString()
val notFoundResponse = Response(code, message, timestamp)