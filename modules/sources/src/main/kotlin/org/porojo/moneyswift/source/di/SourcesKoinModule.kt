package org.porojo.moneyswift.source.di

import org.koin.dsl.module
import org.porojo.moneyswift.source.source.ProductSource
import org.porojo.moneyswift.source.source.ProductSourceImpl

val sourcesKoinModule = module {
    single<ProductSource> {
        ProductSourceImpl()
    }
}