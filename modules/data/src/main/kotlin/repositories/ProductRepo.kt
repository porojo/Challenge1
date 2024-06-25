package repositories

import model.ProductDomain

interface ProductRepo {

    suspend fun getListOfProducts(): List<ProductDomain>
}