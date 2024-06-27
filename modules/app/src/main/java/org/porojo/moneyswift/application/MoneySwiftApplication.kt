package org.porojo.moneyswift.application

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.porojo.moneyswift.features.di.featuresKoinModule
import org.porojo.moneyswift.features.navigation.featureScreenModule

class MoneySwiftApplication : Application() {
    override fun onCreate() {

        super.onCreate()

        ScreenRegistry {
            featureScreenModule
        }

        startKoin {
            androidContext(androidContext = applicationContext)
            modules(modules = featuresKoinModule)
        }
    }
}