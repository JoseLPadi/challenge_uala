package com.example.challengeuala.ui.screens.cities

import androidx.lifecycle.viewModelScope
import com.example.challengeuala.logic.SearchService
import com.example.challengeuala.repository.api_service.interfaces.ApiInterface
import com.example.challengeuala.repository.data_store.FavoriteCitiesRepository
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.ui.core.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.await

class CitiesViewModel(private val retrofitInterface: ApiInterface, private val favoriteCitiesRepository: FavoriteCitiesRepository) : BaseViewModel() {

    private val _listCities = MutableStateFlow<List<City>>(emptyList())
    val listCities: StateFlow<List<City>> = _listCities.asStateFlow()

    private var _listCitiesAux = emptyList<City>()
    lateinit var _listFavoriteCities: List<City>


    private var filterString: String = ""
    private var searchService: SearchService? = null
    private var showingFavorites = false

    fun onFilter(filter: String) {
        if (searchService != null) {
            val result = searchService?.filterList(filter)
            if (showingFavorites) {
                _listCities.value =
                    _listFavoriteCities.subList(result?.first ?: 0, (result?.second ?: 0) + 1)
            } else {
                _listCities.value =
                    _listCitiesAux.subList(result?.first ?: 0, (result?.second ?: 0) + 1)
            }
            this.filterString = filter
        }
    }

    fun onCityFavorite(city: City, favorite: Boolean) {
        city.isFavorite = favorite
        viewModelScope.launch {
            if (favorite)
                favoriteCitiesRepository.addCity(city)
            else favoriteCitiesRepository.removeCity(city)
            getFavoriteCities()
        }
    }

    fun onShowFavorites(showFavorites: Boolean) {
        showingFavorites = showFavorites
        if (showFavorites) {
            _listCities.value = _listFavoriteCities
            searchService?.updateList(_listFavoriteCities)
        } else {
            _listCities.value = _listCitiesAux
            searchService?.updateList(_listCitiesAux)
        }
        onFilter(filterString)
    }

    init {
        viewModelScope.launch {
            getListCities()
            getFavoriteCities()
            updateListCitiesWithFavorites()
            onShowFavorites(showingFavorites)
        }
    }

    suspend fun getListCities() {
        try {
            _listCitiesAux = retrofitInterface.getCities().await().sortedBy { it.name.lowercase() }
            searchService = SearchService(listCities.value)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateListCitiesWithFavorites() {
        var index = 0
        for (city in _listFavoriteCities) {
            while (index < _listCitiesAux.size && _listCitiesAux[index]._id != city._id)
                index++
            _listCitiesAux[index].isFavorite = city.isFavorite
        }

    }

    suspend fun getFavoriteCities() {
        _listFavoriteCities = favoriteCitiesRepository.getCitiess()
        if (showingFavorites) {
            searchService?.updateList(_listFavoriteCities)
            onFilter(filterString)
        }
    }

}