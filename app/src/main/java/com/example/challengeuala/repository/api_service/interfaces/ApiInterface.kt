package com.example.challengeuala.repository.api_service.interfaces

import com.example.challengeuala.repository.entities.City
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("dce8843a8edbe0b0018b32e137bc2b3a/raw/0996accf70cb0ca0e16f9a99e0ee185fafca7af1/cities.json")
    fun getCities(): Call<List<City>>

}