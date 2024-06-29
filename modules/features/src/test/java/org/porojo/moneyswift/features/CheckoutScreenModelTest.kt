package org.porojo.moneyswift.features

import com.stripe.android.paymentsheet.PaymentSheet
import io.mockk.coEvery
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

class CheckoutScreenModelTest {

    private lateinit var checkoutScreenModel: CheckoutScreenModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher = Dispatchers.Unconfined)
        checkoutScreenModel = CheckoutScreenModel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testOnClickPay() {
        val paymentConfig = PaymentConfig(
            key = "publishableKey",
            secret = "paymentIntent",
            config = PaymentSheet.CustomerConfiguration(
                "customer",
                "ephemeralKey"
            )
        )
        checkoutScreenModel.onClickPay()
        val paymentState = checkoutScreenModel.state.value
        assertEquals(paymentConfig, paymentState.paymentConfig)
    }

}