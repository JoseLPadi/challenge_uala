package com.example.challengeuala.ui.screens.cities

import androidx.lifecycle.viewModelScope
import com.example.challengeuala.repository.api_service.interfaces.ApiInterface
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.ui.core.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.await

class CitiesViewModel(private val retrofitInterface: ApiInterface) : BaseViewModel() {

    private val _listCities = MutableStateFlow<List<City>>(emptyList())
    val listCities: StateFlow<List<City>> = _listCities.asStateFlow()

    private val _initArray  =  MutableStateFlow<Int>(0)
    val initArray: StateFlow<Int> = _initArray.asStateFlow()
    private val _finishArray  =  MutableStateFlow<Int>(0)
    val finishArray: StateFlow<Int> = _finishArray.asStateFlow()

    fun onFilter(filter: String){

    }

    fun onCityFavorite(city: City, favorite: Boolean) {

    }

    fun onShowFavorites( showFavorites: Boolean){

    }

    fun getListCities(){
        viewModelScope.launch {
            try {
                _listCities.value = retrofitInterface.getCities().await()
            }catch (e: Exception){
                e.printStackTrace()

            }
        }
    }
}