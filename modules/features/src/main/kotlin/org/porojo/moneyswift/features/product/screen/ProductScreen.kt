package org.porojo.moneyswift.features.product.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.koin.koinScreenModel

object ProductScreen : Screen {

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