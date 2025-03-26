package com.example.challengeuala.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.ui.screens.cities.CitiesViewModel
import com.example.challengeuala.ui.screens.cities.ListCitiesScreen
import com.example.challengeuala.ui.screens.map.MapScreen
import com.example.challengeuala.ui.screens.map.MapViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(isPortrait:Boolean, mapViewModel: MapViewModel, onCitySelectedChangeScreen: (City) -> Unit){
    HomeContent(isPortrait, mapViewModel, onCitySelectedChangeScreen)
}



@Composable
private fun HomeContent(isPortrait: Boolean,mapViewModel: MapViewModel, onCitySelectedChangeScreen: (City) -> Unit){
    val listCitiesviewModel = koinViewModel<CitiesViewModel>()
    val cityList = listCitiesviewModel.listCities.collectAsState()
    val citySelected = mapViewModel.citySelected.collectAsState()

    val weight = if(isPortrait) 1f else 0.6f
    Row (modifier = Modifier.fillMaxSize()){
        Box(modifier=Modifier.weight(weight)) {
            ListCitiesScreen(
                cityList.value,
                { listCitiesviewModel.onFilter(it) },
                { city ->
                    mapViewModel.updateCity(city) // Esto se ejecuta en Portrait
                    if (isPortrait) {
                        onCitySelectedChangeScreen(city) // Esto se ejecuta en Landscape
                    }
                },
                { city, favorite -> listCitiesviewModel.onCityFavorite(city, favorite) },
                { listCitiesviewModel.onShowFavorites(it) },

                modifier = Modifier
            )
        }
        if (!isPortrait) {
            Box(modifier = Modifier.weight(0.4f)) {

                MapScreen(citySelected.value, modifier = Modifier)

            }
        }

    }


}
