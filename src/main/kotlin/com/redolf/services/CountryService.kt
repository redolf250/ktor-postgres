package com.redolf.services

import com.redolf.dto.*
import com.redolf.repositries.CountryRepository
import com.redolf.utils.dataset
import io.ktor.server.application.*

class CountryService {

    private val countryRepository = CountryRepository()

    suspend fun createCountry(country: CountryRequest) : CountryResponse? {
        return countryRepository.insert(country)
    }

    suspend fun findCountryById(id: Int) : CountryResponse? {
        return countryRepository.findById(id);
    }

    suspend fun findAllCountries() : List<CountryResponse?> {
        return countryRepository.findAll();
    }

    suspend fun updateCountry(country: CountryRequest) : CountryResponse? {
       return countryRepository.update(country)
    }
}