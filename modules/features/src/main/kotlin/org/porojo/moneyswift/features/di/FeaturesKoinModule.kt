package org.porojo.moneyswift.features.di

import di.dataKoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.porojo.moneyswift.features.product.viewmodel.ProductViewModel

val featuresKoinModule = module {
    viewModel {
        ProductViewModel(productRepo = get())
    }

    includes(dataKoinModule)
}