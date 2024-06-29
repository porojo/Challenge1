package org.porojo.moneyswift.source.source.products

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.porojo.moneyswift.source.database.ProductData
import org.porojo.moneyswift.source.model.Product

class ProductSourceImpl : ProductSource {
    override suspend fun getProducts(): Flow<List<Product>> = flow {
        emit(value = ProductData.productLists)
    }
}