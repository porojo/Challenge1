package org.porojo.moneyswift.source.dao

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.porojo.moneyswift.source.database.ProductData
import org.porojo.moneyswift.source.model.ProductEntity

class ProductDaoImpl : ProductDAO {
    override suspend fun getProducts(): Flow<List<ProductEntity>> = flow {
        emit(value = ProductData.productEntityLists)
    }
}