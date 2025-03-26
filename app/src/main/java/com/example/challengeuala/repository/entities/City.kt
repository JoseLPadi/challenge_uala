package com.example.challengeuala.repository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_cities")
data class City(val country:String, val name: String, @PrimaryKey val _id: Int, val coord: Coord, var isFavorite: Boolean =false)
