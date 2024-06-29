package org.porojo.moneyswift.features.product.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import model.Product
import org.porojo.moneyswift.features.components.ProductItem
import org.porojo.moneyswift.features.components.TopBar
import org.porojo.moneyswift.features.product.screen_model.ProductScreenModel
import org.porojo.moneyswift.features.product.screen_model.ProductScreenUiState
import org.porojo.moneyswift.features.state.ScreenUiState

object ProductScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel: ProductScreenModel = koinScreenModel()
        val state by screenModel.state.collectAsState()
        val navigator = LocalNavigator.current

        ProductScreenContent(state = state) { product ->
            navigator?.push(CheckoutScreen(product = product))
        }
    }

}

@Composable
fun ProductScreenContent(state: ProductScreenUiState, navigateToCheckoutScreen: (Product) -> Unit) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = { paddingValues ->
            Column(modifier = Modifier.fillMaxWidth()) {
                AnimatedContent(
                    targetState = state.screenUiState,
                    label = "products_animation"
                ) { value ->
                    when (value) {
                        is ScreenUiState.Error -> {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddingValues),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(imageVector = Icons.Rounded.Warning, contentDescription = null)
                                Text("Error loading content")
                            }
                        }

                        ScreenUiState.Loading -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        is ScreenUiState.Success -> {
                            val data = value.data
                            if (data.isEmpty()) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text("No available products")
                                }
                            } else {
                                LazyColumn {
                                    items(data) { product ->
                                        ProductItem(product = product) {
                                            navigateToCheckoutScreen(product)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}