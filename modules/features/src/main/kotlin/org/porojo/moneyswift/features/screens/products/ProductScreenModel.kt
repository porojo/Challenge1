package org.porojo.moneyswift.features.screens.products

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.Product
import org.porojo.moneyswift.features.state.ScreenUiState
import repositories.ProductRepo

data class ProductScreenUiState(
    val screenUiState: ScreenUiState<List<Product>> = ScreenUiState.Loading
)

class ProductScreenModel(
    private val productRepo: ProductRepo
) : StateScreenModel<ProductScreenUiState>(ProductScreenUiState()) {

    init {
        getProductsListItems()
    }

    private fun getProductsListItems() {
        screenModelScope.launch {
            productRepo.getListOfProducts().collect { products ->
                mutableState.update { it.copy(screenUiState = ScreenUiState.Success(data = products)) }
            }
        }
    }
}