package com.example.challengeuala.ui.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.challengeuala.ui.screens.cities.CitiesViewModel
import com.example.challengeuala.ui.screens.cities.ListCitiesScreen
import com.example.challengeuala.ui.screens.map.MapScreen
import com.example.challengeuala.ui.screens.map.MapViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(isPortrait:Boolean){
    HomeContent(isPortrait)
}



@Composable
private fun HomeContent(isPortrait: Boolean){
    val listCitiesviewModel = koinViewModel<CitiesViewModel>()
    val mapViewModel = koinViewModel<MapViewModel>()
    val cityList = listCitiesviewModel.listCities.collectAsState()
    val startList = listCitiesviewModel.initArrayListCities.collectAsState()
    val finishList = listCitiesviewModel.finishArrayListCities.collectAsState()
    val citySelected = mapViewModel.citySelected.collectAsState()


    Row {
        ListCitiesScreen(cityList.value,
                        startList.value,
                        finishList.value,
                        { listCitiesviewModel.onFilter(it) },
                        {mapViewModel.updateCity(it)},
                        {city, favorite -> listCitiesviewModel.onCityFavorite(city, favorite)},
                        { listCitiesviewModel.onShowFavorites(it) } )
        if (!isPortrait){

            MapScreen(citySelected.value)

        }

    }


}