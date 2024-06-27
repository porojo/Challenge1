package org.porojo.moneyswift.features.product.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import org.porojo.moneyswift.features.product.screen_model.ProductScreenModel
import org.porojo.moneyswift.features.product.screen_model.ProductScreenUiState

class ProductScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel: ProductScreenModel = koinScreenModel()
        val state by screenModel.state.collectAsState()

        ProductScreenContent(state = state)
    }

}

@Composable
fun ProductScreenContent(state: ProductScreenUiState) {

}