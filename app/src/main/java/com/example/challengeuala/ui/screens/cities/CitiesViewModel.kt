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
    private val _initArrayListCities  =  MutableStateFlow<Int>(0)
    val initArrayListCities: StateFlow<Int> = _initArrayListCities.asStateFlow()
    private val _finishArrayListCities  =  MutableStateFlow<Int>(0)
    val finishArrayListCities: StateFlow<Int> = _finishArrayListCities.asStateFlow()


    private var filterString : String = ""

    fun onFilter(filter: String){
        this.filterString = filter
    }

    fun onCityFavorite(city: City, favorite: Boolean) {
        //update dataStorage

    }

    fun onShowFavorites( showFavorites: Boolean){

        if (showFavorites){
            //filter favorite

        } else {
            //filter unfavorite
        }

    }

    init {
        getListCities()
    }
    fun getListCities(){
        viewModelScope.launch {
            try {
                _listCities.value = retrofitInterface.getCities().await().sortedBy { it.name }
                _initArrayListCities.value=0
                _finishArrayListCities.value=_listCities.value.size
            }catch (e: Exception){
                e.printStackTrace()

            }
        }
    }

    fun getFavoriteCities(){
        //Call datasorage and return a list of ids of favorite cities.

        //update listFavorites,_finishArrayFavourite,_initArrayFavourite

    }
}