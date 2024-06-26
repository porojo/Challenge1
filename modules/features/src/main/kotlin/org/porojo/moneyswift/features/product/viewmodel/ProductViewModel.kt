package org.porojo.moneyswift.features.product.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.porojo.moneyswift.features.product.state.ProductScreenState
import repositories.ProductRepo

class ProductViewModel(
    private val productRepo: ProductRepo
) : ViewModel() {

    private val _productScreenState: MutableStateFlow<ProductScreenState> = MutableStateFlow(value = ProductScreenState())
    val productScreenState: StateFlow<ProductScreenState> = _productScreenState.asStateFlow()

    private fun getProducts() {
        viewModelScope.launch {
            productRepo.getListOfProducts().collect { productList ->
                _productScreenState.update {
                    it.copy(products = productList)
                }
            }
        }
    }

}