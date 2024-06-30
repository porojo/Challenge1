package org.porojo.moneyswift.features

import com.stripe.android.paymentsheet.PaymentSheet
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.porojo.moneyswift.features.screens.checkout.CheckoutScreenModel
import org.porojo.moneyswift.features.screens.checkout.PaymentConfig
import repositories.payment.PaymentRepository

class CheckoutScreenModelTest {

    private val paymentRepository: PaymentRepository = mockk(relaxed = true)

    private lateinit var checkoutScreenModel: CheckoutScreenModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher = Dispatchers.Unconfined)
        checkoutScreenModel = CheckoutScreenModel(repository = paymentRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testOnClickPay() = runTest {
        val amount = checkoutScreenModel.state.value.product?.productPrice?.toLong()
        val info = amount?.let { paymentRepository.getPaymentInfo(amount = it, currency = "USD") }
        info?.let { payment ->
            val paymentConfig = PaymentConfig(
                publishableKey = payment.publishableKey,
                paymentIntentClientSecret = payment.paymentIntent,
                customerConfig = PaymentSheet.CustomerConfiguration(
                    payment.customer,
                    payment.ephemeralKey
                )
            )
            checkoutScreenModel.onClickPay()
            val paymentState = checkoutScreenModel.state.value
            assertEquals(paymentConfig, paymentState.paymentConfig)
        }
    }
}