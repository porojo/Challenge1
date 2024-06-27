package di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import org.porojo.moneyswift.source.di.sourcesKoinModule
import repositories.ProductRepo
import repositories.ProductRepoImpl

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

    includes(sourcesKoinModule)
}