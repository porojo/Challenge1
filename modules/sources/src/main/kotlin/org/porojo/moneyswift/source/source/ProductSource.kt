package org.porojo.moneyswift.source.source

import kotlinx.coroutines.flow.Flow
import org.porojo.moneyswift.source.model.Product

interface ProductSource {
    suspend fun getProducts(): Flow<List<Product>>
}