package org.porojo.moneyswift.source.source.payment

import com.stripe.Stripe
import com.stripe.model.Customer.create
import com.stripe.model.EphemeralKey
import com.stripe.model.PaymentIntent
import com.stripe.param.CustomerCreateParams
import com.stripe.param.EphemeralKeyCreateParams
import com.stripe.param.PaymentIntentCreateParams
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.porojo.moneyswift.source.model.PaymentDTO
import org.porojo.moneyswift.sources.BuildConfig

class PaymentSourceImpl(private val dispatcher: CoroutineDispatcher) : PaymentSource {

    override suspend fun fetchPaymentInfo(amount: Long, currency: String): PaymentDTO =
        withContext(dispatcher) {
            // api key
            Stripe.apiKey = BuildConfig.stripeApiKey

            // Create customer object
            val customerParams = CustomerCreateParams.builder().build()
            val customer = create(customerParams)

            // Create ephemeralKey object
            val ephemeralKeyParams = EphemeralKeyCreateParams.builder()
                .setStripeVersion("2024-04-10")
                .setCustomer(customer.id)
                .build()
            val ephemeralKey: EphemeralKey = EphemeralKey.create(ephemeralKeyParams)

            // Create payment intent object
            val paymentIntentParams = PaymentIntentCreateParams.builder()
                .setAmount(amount) // You can pass amount as a parameter
                .setCurrency(currency) // Set valid currency eg. usd, euro
                .setCustomer(customer.id)
                .build()

            val paymentIntent = PaymentIntent.create(paymentIntentParams)

            PaymentDTO(
                paymentIntent = paymentIntent.clientSecret,
                ephemeralKey = ephemeralKey.secret,
                customer = customer.id,
                publishableKey = BuildConfig.stripePublishableKey
            )
        }

}