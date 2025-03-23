package com.example.challengeuala.ui.screens.cities

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.challengeuala.repository.entities.City

@Composable
fun ListCitiesScreen(onFilter: (String) -> Unit,
                     onCitySelected: (City) -> Unit,
                     onCityFavorite: (City, Boolean) ->Unit,
                     onShowFavorites: (Boolean)->Unit){
    ListCitiesContent(onFilter, onCitySelected, onCityFavorite, onShowFavorites)
}

@Composable
private fun ListCitiesContent(onFilter: (String) -> Unit,
                              onCitySelected: (City) -> Unit,
                              onCityFavorite: (City, Boolean) ->Unit,
                              onShowFavorites: (Boolean)->Unit){
    Text(
        text = "content list ",
    )

}


@Composable
@Preview
private fun ListCitiesPreview(){
    ListCitiesScreen({_ ->},{_ ->}, {_,_ ->},{_ ->})
}