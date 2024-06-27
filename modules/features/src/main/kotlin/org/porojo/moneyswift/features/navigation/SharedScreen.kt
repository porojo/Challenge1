package org.porojo.moneyswift.features.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {

    data object ProductScreen : SharedScreen()

    data object CheckoutScreen : SharedScreen()

    data object ConfirmationScreen : SharedScreen()

}