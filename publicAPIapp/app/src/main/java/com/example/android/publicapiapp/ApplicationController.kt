package com.example.android.publicapiapp

import android.app.Application
import com.example.android.publicapiapp.module.BreakingBadModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationController: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@ApplicationController)
            modules(BreakingBadModule)
        }
    }
}