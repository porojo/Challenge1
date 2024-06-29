package org.porojo.moneyswift.source.di

import org.koin.dsl.module
import org.porojo.moneyswift.source.source.payment.PaymentSource
import org.porojo.moneyswift.source.source.payment.PaymentSourceImpl
import org.porojo.moneyswift.source.source.products.ProductSource
import org.porojo.moneyswift.source.source.products.ProductSourceImpl

val sourcesKoinModule = module {
    single<ProductSource> { ProductSourceImpl() }
    single<PaymentSource> { PaymentSourceImpl(dispatcher = get()) }
}