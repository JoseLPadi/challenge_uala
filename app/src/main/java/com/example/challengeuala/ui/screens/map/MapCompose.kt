package com.example.challengeuala.ui.screens.map

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengeuala.repository.entities.City
import com.example.challengeuala.repository.entities.Coord
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(citySelected: City?) {
    MapContent(citySelected)
}

@Composable
private fun MapContent(citySelected: City?){

    if (citySelected!=null) {
        val coord = LatLng(citySelected.coord.lat, citySelected.coord.lon)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(coord, 12f) // Zoom adecuado para el marcador
        }
        GoogleMap(
            modifier = Modifier.padding(16.dp),
            cameraPositionState = cameraPositionState

        ) {
            Marker(state = MarkerState(position =  coord),
                title = citySelected.name)
        }

    }

}

@Composable
@Preview
private fun MapScreenPreview(){
    val city= City("RU", "Russian Federation", 2017370, Coord(100.0, 60.0))
    MapScreen(city)
}