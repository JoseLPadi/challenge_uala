package com.example.challengeuala.repository.entities

data class City(val country:String, val name: String,val _id: Int, val coord: Coord, var isFavorite: Boolean =false)
