package com.example.challengeuala.repository.data_store

import androidx.lifecycle.LiveData
import com.example.challengeuala.repository.entities.City


class FavoriteCitiesRepository(private val db: AppDataBase) {

    private val cityDAO = db.cityDao()

    suspend fun addCity(city:City){
        cityDAO.insertCity(city)
    }
    suspend fun removeCity(city: City){
        cityDAO.deleteCity(city)
    }
    //not working
    fun getCities(): LiveData<List<City>>{
            return cityDAO.getAllCities()

    }
    suspend fun getCitiess(): List<City>{
        return cityDAO.getAllCitiess()

    }
}