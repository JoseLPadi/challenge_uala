package com.example.challengeuala.dependency_injection

import com.example.challengeuala.repository.api_service.RetrofitClient
import com.example.challengeuala.repository.api_service.interfaces.ApiInterface
import com.example.challengeuala.repository.data_store.AppDataBase
import com.example.challengeuala.repository.data_store.CoordConverter
import com.example.challengeuala.repository.data_store.FavoriteCitiesRepository
import com.example.challengeuala.ui.core.BaseViewModel
import com.example.challengeuala.ui.screens.cities.CitiesViewModel
import com.example.challengeuala.ui.screens.map.MapViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val koinModule  = module {
//
    single { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }
    single { CoordConverter(get()) }

    single { RetrofitClient.retrofitClient.create(ApiInterface::class.java)}
    single { AppDataBase.getDatabase(androidContext(),get()) }
    single { FavoriteCitiesRepository(get()) }
    viewModelOf( ::MapViewModel)
    viewModel { CitiesViewModel(get(),get()) }
    viewModel{ BaseViewModel() }
}