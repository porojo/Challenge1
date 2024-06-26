package org.porojo.moneyswift.features.product.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.Product
import repositories.ProductRepo

class ProductViewModel(
    private val productRepo: ProductRepo
) : ViewModel() {

    private val _productList: MutableStateFlow<List<Product>> = MutableStateFlow(value = emptyList())
    val productList: StateFlow<List<Product>> = _productList.asStateFlow()

    init {

    }

    private fun getProducts() {

    }

}