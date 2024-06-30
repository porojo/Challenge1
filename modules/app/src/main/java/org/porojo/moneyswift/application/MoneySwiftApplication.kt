package org.porojo.moneyswift.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.porojo.moneyswift.features.di.featuresKoinModule
import timber.log.Timber

class MoneySwiftApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupKoin() {
        startKoin {
            androidContext(androidContext = applicationContext)
            modules(modules = featuresKoinModule)
        }
    }
}