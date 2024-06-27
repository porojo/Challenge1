package org.porojo.moneyswift.features.product.screen_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import repositories.ProductRepo

class ProductViewModel(
    private val productRepo: ProductRepo
) : ViewModel() {

    private fun getProducts() {
        viewModelScope.launch {

        }
    }

}