package com.example.challengeuala.ui.screens.map

import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.ui.core.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MapViewModel : BaseViewModel() {

    private val _citySelected = MutableStateFlow<City?>(null)
    val citySelected: StateFlow<City?> = _citySelected.asStateFlow()

    fun updateCity(city:City){
        _citySelected.value = city
    }



}