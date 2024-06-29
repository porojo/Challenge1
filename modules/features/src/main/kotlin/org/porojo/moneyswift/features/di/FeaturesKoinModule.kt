package org.porojo.moneyswift.features.di

import di.dataKoinModule
import org.koin.dsl.module
import org.porojo.moneyswift.features.screens.checkout.CheckoutScreenModel
import org.porojo.moneyswift.features.screens.products.ProductScreenModel

val featuresKoinModule = module {
    factory {
        ProductScreenModel(productRepo = get())
    }
    factory {
        CheckoutScreenModel(repository = get())
    }

    includes(dataKoinModule)
}