package org.porojo.moneyswift.features.screens.checkout

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.stripe.android.paymentsheet.PaymentSheet
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.PaymentState
import model.Product
import repositories.payment.PaymentRepository
import timber.log.Timber

data class PaymentConfig(
    val publishableKey: String,
    val paymentIntentClientSecret: String,
    val customerConfig: PaymentSheet.CustomerConfiguration
)

data class CheckoutScreenUiState(
    val paymentConfig: PaymentConfig? = null,
    val product: Product? = null,
    val paymentState: PaymentState? = null
)

class CheckoutScreenModel(
    private val repository: PaymentRepository
) : StateScreenModel<CheckoutScreenUiState>(CheckoutScreenUiState()) {

    fun onValueChange(product: Product) {
        mutableState.update { it.copy(product = product) }
    }

    fun onClickPay() {
        val amount = state.value.product?.productPrice?.toLong() ?: return
        screenModelScope.launch {
            val info = repository.getPaymentInfo(amount = amount, currency = "USD")
            info?.let { payment ->
                Timber.d("Payment -> $payment")
                mutableState.update {
                    it.copy(
                        paymentConfig = PaymentConfig(
                            publishableKey = payment.publishableKey,
                            paymentIntentClientSecret = payment.paymentIntent,
                            customerConfig = PaymentSheet.CustomerConfiguration(
                                payment.customer,
                                payment.ephemeralKey
                            )
                        )
                    )
                }
            }

        }
    }

    fun onPaymentFinished(paymentState: PaymentState) {
        screenModelScope.launch {
            mutableState.update { it.copy(paymentConfig = null, paymentState = paymentState) }
            delay(500)
            mutableState.update { it.copy(paymentState = null) }
        }
    }

}