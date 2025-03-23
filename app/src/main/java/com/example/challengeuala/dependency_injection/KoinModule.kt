package com.example.challengeuala.dependency_injection

import com.example.challengeuala.repository.api_service.RetrofitClient
import com.example.challengeuala.repository.api_service.interfaces.ApiInterface
import com.example.challengeuala.ui.core.BaseViewModel
import com.example.challengeuala.ui.screens.cities.CitiesViewModel
import com.example.challengeuala.ui.screens.map.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val koinModule  = module {
//
    single { RetrofitClient.retrofitClient.create(ApiInterface::class.java)}
    viewModelOf( ::MapViewModel)
    viewModel { CitiesViewModel(get()) }
    viewModel{ BaseViewModel() }
}