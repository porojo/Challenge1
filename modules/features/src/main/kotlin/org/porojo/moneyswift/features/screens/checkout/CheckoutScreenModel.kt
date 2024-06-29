package org.porojo.moneyswift.features.screens.checkout

import cafe.adriel.voyager.core.model.StateScreenModel
import com.stripe.android.paymentsheet.PaymentSheet
import kotlinx.coroutines.flow.update
import model.Product

data class PaymentConfig(
    val key: String,
    val secret: String,
    val config: PaymentSheet.CustomerConfiguration
)

data class CheckoutScreenUiState(
    val paymentConfig: PaymentConfig? = null,
    val product: Product? = null
)

class CheckoutScreenModel : StateScreenModel<CheckoutScreenUiState>(CheckoutScreenUiState()) {

    fun onValueChange(product: Product){
        mutableState.update { it.copy(product = product) }
    }

    fun onClickPay() {
        mutableState.update {
            it.copy(
                paymentConfig = PaymentConfig(
                    key = "publishableKey",
                    secret = "paymentIntent",
                    config = PaymentSheet.CustomerConfiguration(
                        "customer",
                        "ephemeralKey"
                    )
                )
            )
        }
    }

}