package com.example.challengeuala.ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.repository.entities.Coord


@Composable
fun ItemCityScreen(city: City){
    ItemCityContent(city)
}

@Composable
private fun ItemCityContent(city: City){

}



@Composable
@Preview
private fun ItemCityPreview(){
    ItemCityContent(City("","",2, Coord(1.1,1.1),true))
}