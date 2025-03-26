package com.example.challengeuala

import android.app.Application
import com.example.challengeuala.dependency_injection.koinApiServiceModule
import com.example.challengeuala.dependency_injection.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChallengeApplication: Application() {
    companion object {
        lateinit var instance: ChallengeApplication
            private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@ChallengeApplication)
            modules(koinModule, koinApiServiceModule)
        }
    }
}