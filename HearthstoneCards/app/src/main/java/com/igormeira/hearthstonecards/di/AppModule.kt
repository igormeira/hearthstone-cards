package com.igormeira.hearthstonecards.di

import android.app.Application
import org.koin.core.context.startKoin

class AppModule: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            modules(listOf())
        }
    }
}