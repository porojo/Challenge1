package org.porojo.moneyswift.features.di

import di.dataKoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featuresKoinModule = module {
    viewModel {
        ProductViewModel(productRepo = get())
    }

    includes(dataKoinModule)
}