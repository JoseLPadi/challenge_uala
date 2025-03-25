package com.example.challengeuala.dependency_injection

import com.example.challengeuala.repository.api_service.RetrofitClient
import com.example.challengeuala.repository.api_service.interfaces.ApiInterface
import org.koin.dsl.module


val koinApiServiceModule  = module {

    single { RetrofitClient.retrofitClient.create(ApiInterface::class.java)}

    }