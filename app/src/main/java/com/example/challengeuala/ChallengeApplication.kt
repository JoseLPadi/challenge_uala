package com.example.challengeuala

import android.app.Application
import com.example.challengeuala.dependency_injection.koinApiServiceModule
import com.example.challengeuala.dependency_injection.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChallengeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ChallengeApplication)
            modules(koinModule, koinApiServiceModule)
        }
    }
}