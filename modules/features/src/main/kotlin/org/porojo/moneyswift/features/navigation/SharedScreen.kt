package org.porojo.moneyswift.features.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import model.Product

sealed class SharedScreen : ScreenProvider {

    data object ProductScreen : SharedScreen()

    data class CheckoutScreen(val product: Product, val onPaymentClicked: () -> Unit) :
        SharedScreen()

    data object ConfirmationScreen : SharedScreen()

}