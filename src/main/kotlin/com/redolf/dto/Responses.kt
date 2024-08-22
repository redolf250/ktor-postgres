package com.redolf.dto

import kotlinx.serialization.Serializable

@Serializable
data class CountryResponse(val id: Int, val name: String, val continent: String, val population: Int, val createdAt: String)

@Serializable
data class Response(val code: Int, val timestamp: String, val message: String)