package com.redolf.utils

import com.redolf.dto.CountryResponse
import com.redolf.models.Country
import org.jetbrains.exposed.sql.ResultRow

fun countryMapper(row: ResultRow?) : CountryResponse? {
    return if (row == null) null
    else CountryResponse(
        id = row[Country.id],
        name = row[Country.name],
        continent = row[Country.continent],
        population = row[Country.population],
        createdAt = row[Country.createdAt].toString()
    )
}