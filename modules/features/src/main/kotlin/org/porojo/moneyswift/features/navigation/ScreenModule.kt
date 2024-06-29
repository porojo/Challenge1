package org.porojo.moneyswift.features.navigation

import cafe.adriel.voyager.core.registry.screenModule
import org.porojo.moneyswift.features.product.screens.CheckoutScreen
import org.porojo.moneyswift.features.product.screens.ProductScreen
import org.porojo.moneyswift.features.product.screens.ConfirmationScreen

val featureScreenModule = screenModule {
    register<SharedScreen.ProductScreen> { ProductScreen }

    register<SharedScreen.CheckoutScreen> { provider ->
        CheckoutScreen(product = provider.product)
    }

    register<SharedScreen.ConfirmationScreen> {
        ConfirmationScreen()
    }
}