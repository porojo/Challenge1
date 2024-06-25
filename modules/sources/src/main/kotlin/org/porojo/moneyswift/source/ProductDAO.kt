package org.porojo.moneyswift.source

interface ProductDAO {
    suspend fun getProducts(): List<Product>
}