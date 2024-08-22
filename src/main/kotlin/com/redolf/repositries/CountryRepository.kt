package com.redolf.repositries

import com.redolf.db.DatabaseFactory.dbQuery
import com.redolf.dto.CountryRequest
import com.redolf.dto.CountryResponse
import com.redolf.models.Country
import com.redolf.utils.countryMapper
import org.h2.command.dml.Update
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement

class CountryRepository : IRepository<Int, CountryRequest, CountryResponse> {

    override suspend fun insert(t: CountryRequest): CountryResponse? {
        var statement: InsertStatement<Number>? = null
        dbQuery{
            statement = Country.insert {
                it[name] = t.name
                it[continent] = t.continent
                it[population] = t.population
            }
        }
        return countryMapper(statement?.resultedValues?.get(0))

    }

    override suspend fun findById(id: Int): CountryResponse? {
        val dbQuery = dbQuery {
            Country.select {
                Country.id.eq(id)
            }.map { countryMapper(it) }.singleOrNull()
        }
        return dbQuery;
    }

    override suspend fun update(t: CountryRequest): CountryResponse? {

        dbQuery {
//            var statement = UpdateStatement(
//                Country,
//                limit = TODO(),
//                where = TODO()
//            )
//            statement.set(Country.name, t.name)
//            statement.set(Country.continent, t.continent)
//            statement.set(Country.population, t.population)
//            statement.where{ Country.id.eq(1) }

        }
//        return countryMapper(statement)
        TODO("Not yet implemented")
    }

    override suspend fun insertMany(t: List<CountryRequest>): List<CountryResponse?> {
        TODO("Not yet implemented")
    }

    override suspend fun findAllById(t: List<Int>): List<CountryResponse?> {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): List<CountryResponse?> {
        val dbQuery = dbQuery {
            Country.selectAll().map { countryMapper(it) }
        }
        return dbQuery
    }

    override suspend fun deleteMany(t: List<Int>): Int {
        TODO("Not yet implemented")
    }

    override suspend fun delete(t: Int): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateMany(t: List<CountryRequest>): Int {
        TODO("Not yet implemented")
    }
}