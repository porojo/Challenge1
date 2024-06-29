package org.porojo.moneyswift.features.screens.confirmation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.porojo.moneyswift.features.screens.products.ProductScreen

class ConfirmationScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Confirmation",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        ) { paddingValues ->
            ConfirmationScreenContent(
                modifier = Modifier.padding(paddingValues = paddingValues),
                onHomeClicked = {
                    navigator.push(item = ProductScreen)
                }
            )
        }
    }

}

@Composable
fun ConfirmationScreenContent(modifier: Modifier, onHomeClicked: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize().testTag(tag = "ConfirmationScreenColumn"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = modifier.testTag(tag = "ConfirmationScreenText"),
            text = "Your payment is successful!",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Button(modifier = modifier.testTag(tag = "ConfirmationScreenButton"), onClick = onHomeClicked) {
            Text(
                modifier = modifier.testTag(tag = "ButtonText"),
                text = "Home",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}