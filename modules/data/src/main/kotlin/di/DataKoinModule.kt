package di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import org.porojo.moneyswift.source.di.sourcesKoinModule
import repositories.payment.PaymentRepository
import repositories.payment.PaymentRepositoryImpl
import repositories.product.ProductRepo
import repositories.product.ProductRepoImpl

val dataKoinModule = module {
    single<CoroutineDispatcher> {
        Dispatchers.IO
    }

    single<ProductRepo> {
        ProductRepoImpl(
            productSource = get(),
            coroutineDispatcher = get()
        )
    }
    single<PaymentRepository> {
        PaymentRepositoryImpl(remoteSource = get())
    }

    includes(sourcesKoinModule)
}