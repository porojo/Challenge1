package org.porojo.moneyswift.features.di

import di.dataKoinModule
import org.koin.dsl.module
import org.porojo.moneyswift.features.product.screen_model.ProductScreenModel

val featuresKoinModule = module {
    factory {
        ProductScreenModel(productRepo = get())
    }

    includes(dataKoinModule)
}