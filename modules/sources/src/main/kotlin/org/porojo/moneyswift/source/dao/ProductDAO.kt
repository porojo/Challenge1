package org.porojo.moneyswift.source.dao

import kotlinx.coroutines.flow.Flow
import org.porojo.moneyswift.source.model.ProductEntity

interface ProductDAO {
    suspend fun getProducts(): Flow<List<ProductEntity>>
}