package com.redolf.dto

import kotlinx.serialization.Serializable

@Serializable
data class CountryRequest(val name: String, val continent: String, val population: Int)
