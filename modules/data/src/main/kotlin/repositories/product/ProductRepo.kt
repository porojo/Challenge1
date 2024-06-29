package repositories.product

import kotlinx.coroutines.flow.Flow
import model.Product

interface ProductRepo {
    suspend fun getListOfProducts(): Flow<List<Product>>
}