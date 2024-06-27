package org.porojo.moneyswift.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.porojo.moneyswift.features.di.featuresKoinModule

class MoneySwiftApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = applicationContext)
            modules(modules = featuresKoinModule)
        }
    }
}