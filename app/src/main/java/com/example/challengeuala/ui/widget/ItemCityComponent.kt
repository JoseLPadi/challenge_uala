package com.example.challengeuala.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.repository.entities.Coord
import com.example.challengeuala.R


@Composable
fun ItemCityWidget(city: City,
                   onCityFavorite: (City, Boolean) ->Unit,
                   onCitySelected: (City) -> Unit,
                   modifier:Modifier = Modifier){
    ItemCityWidgetContent(city, onCityFavorite, onCitySelected,modifier)
}

@Composable
private fun ItemCityWidgetContent(city: City, onCityFavorite: (City, Boolean) ->Unit,onCitySelected: (City) -> Unit,modifier: Modifier){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onCitySelected(city) },
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (modifier = Modifier.weight(1f).padding(16.dp,8.dp)){
                Text(
                    text = "${city.name} - ${city._id}" )
                Text(
                    text = "Lat=${city.coord.lat} - Lon=${city.coord.lon}"
                )
            }
            IconToggleButton(checked = city.isFavorite,
                onCheckedChange = {onCityFavorite(city, !city.isFavorite)}) {
                Icon(
                     painter = if (city.isFavorite) painterResource(R.drawable.favorite) else painterResource(R.drawable.unfavorite),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Yellow
                )
            }
        }
    }
}



@Composable
@Preview
private fun ItemCityPreview(){
    ItemCityWidget(City("country","name",22, Coord(1.1,1.1),true), {_,_ ->},{})
}