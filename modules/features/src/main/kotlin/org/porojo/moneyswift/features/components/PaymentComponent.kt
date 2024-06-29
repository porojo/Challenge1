package org.porojo.moneyswift.features.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import com.stripe.android.paymentsheet.rememberPaymentSheet
import timber.log.Timber

@Composable
fun PaymentComponent(
    customerConfig: PaymentSheet.CustomerConfiguration,
    paymentIntentClientSecret: String,
    publishableKey: String,
    onPaymentCancelled: () -> Unit = {},
    onPaymentFailed: () -> Unit = {},
    onPaymentCompleted: () -> Unit = {}
) {

    PaymentConfiguration.init(LocalContext.current, publishableKey)

    fun onPaymentSheetResult(paymentSheetResult: PaymentSheetResult) {
        Timber.d("Payment -> $paymentSheetResult")
        when (paymentSheetResult) {
            is PaymentSheetResult.Canceled -> onPaymentCancelled()
            is PaymentSheetResult.Failed -> onPaymentFailed()
            is PaymentSheetResult.Completed -> onPaymentCompleted()
        }
    }

    val paymentSheet = rememberPaymentSheet(::onPaymentSheetResult)
    paymentSheet.presentWithPaymentIntent(
        paymentIntentClientSecret = paymentIntentClientSecret,
        configuration = PaymentSheet.Configuration(
            merchantDisplayName = "Money Swift",
            customer = customerConfig,
            allowsDelayedPaymentMethods = true
        )
    )

}

