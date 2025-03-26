package com.example.challengeuala.ui.screens.cities

import androidx.lifecycle.viewModelScope
import com.example.challengeuala.logic.SearchService
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

    private var _listCitiesAux = emptyList<City>()


    private var filterString : String = ""
    private  var searchService: SearchService? = null

    fun onFilter(filter: String){
        if( searchService!=null) {
            val result = searchService?.filterList(filter)
            _listCities.value = _listCitiesAux.subList(result?.first ?: 0,  (result?.second ?: 0 )+ 1)
            this.filterString = filter

        }
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
                _listCitiesAux =  retrofitInterface.getCities().await().sortedBy { it.name.lowercase() }
                _listCities.value = _listCitiesAux
                searchService = SearchService(listCities.value)
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