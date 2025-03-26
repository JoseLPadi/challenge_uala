package com.example.challengeuala.repository.data_store

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.challengeuala.repository.entities.Coord
import com.squareup.moshi.Moshi

@ProvidedTypeConverter
class CoordConverter (private val moshi: Moshi) {

    private val adapter = moshi.adapter(Coord::class.java)

    @TypeConverter
    fun fromCoord(coord: Coord): String {
        return adapter.toJson(coord)
    }

    @TypeConverter
    fun toCoord(json: String): Coord? {
        return adapter.fromJson(json)
    }
}