package org.porojo.moneyswift.features.product.state

import model.Product

data class ProductScreenState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)