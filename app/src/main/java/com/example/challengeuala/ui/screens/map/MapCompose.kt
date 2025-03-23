package com.example.challengeuala.ui.screens.map

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.challengeuala.repository.entities.City
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MapScreen(citySelected: StateFlow<City?>) {
    MapContent()
}

@Composable
private fun MapContent(){
    Text(
        text = "content map",
    )
}