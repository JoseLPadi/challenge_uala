package com.example.challengeuala.repository.data_store.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challengeuala.repository.entities.City

@Dao
interface  CityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: City)

    @Query("SELECT * FROM favorite_cities")
    fun getAllCities(): LiveData<List<City>>

    @Query("SELECT * FROM favorite_cities ORDER BY name COLLATE NOCASE ASC")
    suspend fun getAllCitiess(): List<City>

    @Delete
    suspend fun deleteCity(city: City)

}