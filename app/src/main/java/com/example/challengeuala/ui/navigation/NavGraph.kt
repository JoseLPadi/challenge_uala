package com.example.challengeuala.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    val mapViewModel = koinViewModel<MapViewModel>()

    NavHost(navController = navController,
        modifier = modifier,
        startDestination = Destinations.HOME_SCREEN) {

        composable(route = Destinations.HOME_SCREEN) {

            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .navigationBarsPadding()
            ) {
                HomeScreen(isPortrait, mapViewModel) { city ->
                    // Navegar pasando el objeto City serializado
                    navController.navigate(Destinations.DETAIL_CITY_MAP_ROUTE)
                }
            }
        }

        composable(route = Destinations.DETAIL_CITY_MAP_ROUTE) {
            val city = mapViewModel.citySelected.collectAsState()

            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .navigationBarsPadding()
            ) {
                MapScreen(city.value, Modifier)
            }
        }

    }

}