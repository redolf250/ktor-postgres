package com.redolf.routes

import com.redolf.dto.CountryRequest
import com.redolf.dto.CountryResponse
import com.redolf.dto.Response
import com.redolf.services.CountryService
import com.redolf.utils.notFoundResponse
import io.github.smiley4.ktorswaggerui.dsl.route
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.LocalDateTime
import java.util.Optional

fun Routing.countryRoute(){

    val service = CountryService()

    route("/api/v1") {

        get("/") {
            call.respondText ("Welcome to country route!!!",status=HttpStatusCode.OK)
        }

        post("/country") {
            val request = call.receive<CountryRequest>()
            val country: CountryResponse? = service.createCountry(request)
            if (country != null) {
                call.respond(HttpStatusCode.Created,country)
            }
        }

        get("/countries/{id}") {
            val id = call.parameters["id"]?.toInt() ?: return@get call.respond(HttpStatusCode.BadRequest,"Invalid ID")
            val country = service.findCountryById(id)
            if (country != null) {
                    call.respond(HttpStatusCode.Found,country)
                }else{
                    call.respond(HttpStatusCode.NotFound, notFoundResponse)
                }


        }

        get("/countries") {
            val  records = service.findAllCountries()
            call.respond(HttpStatusCode.OK,records)
        }
    }

}