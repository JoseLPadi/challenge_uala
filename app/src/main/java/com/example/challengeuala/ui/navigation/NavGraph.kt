package com.example.challengeuala.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challengeuala.ui.screens.home.HomeScreen
import com.example.challengeuala.ui.screens.map.MapScreen
import com.example.challengeuala.ui.screens.map.MapViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraphComposable(isPortrait: Boolean, modifier:Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = Destinations.HOME_SCREEN){

        composable(route = Destinations.HOME_SCREEN) {
            HomeScreen(isPortrait)
        }

        composable (route = Destinations.DETAIL_CITY_MAP_ROUTE){
            val mapViewModel = koinViewModel<MapViewModel>()
            MapScreen(mapViewModel.citySelected)
        }
    }

}