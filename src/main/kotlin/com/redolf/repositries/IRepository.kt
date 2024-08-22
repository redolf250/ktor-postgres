package com.redolf.repositries

import com.redolf.dto.CountryResponse
import org.jetbrains.exposed.sql.ResultRow

/**
 * @param ID: The ID type of the model class.
 * @param T: The model class to be passed as parameter to interact with the
 * database.
 * @author: Redolf Asamaning
 */

interface IRepository<ID , T, R> {

    suspend fun insert(t: T ) : R?

    suspend fun insertMany(t: List<T> ) : List<R?>

    suspend fun findById(id: ID) : R?

    suspend fun findAllById(t: List<ID>) : List<R?>

    suspend fun findAll() : List<R?>

    suspend fun update(t: T) : R?

    suspend fun updateMany(t: List<T>) : Int

    suspend fun delete(t: ID) : Int

    suspend fun deleteMany(t: List<ID>) : Int
}