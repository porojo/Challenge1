package org.porojo.moneyswift.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import org.porojo.moneyswift.features.screens.products.ProductScreen
import org.porojo.moneyswift.ui.MoneySwiftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoneySwiftTheme {
                Navigator(ProductScreen)
            }
        }
    }
}