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

class PaymentSourceImpl(private val dispatcher: CoroutineDispatcher) : PaymentSource {

    override suspend fun fetchPaymentInfo(amount: Long, currency: String): PaymentDTO? =
        withContext(dispatcher) {
            // api key
            Stripe.apiKey = "sk_test_51PWHBiIRrHonC9wffmfpGzkWwQhQHjvd4UmY4ALeQFT8sKasuRBBwxecbB6AXYqgV0nZovOvUjpjecHgTI8YOJbK00Al7dok8w"

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
                publishableKey = "pk_test_51PWHBiIRrHonC9wf5LEHkXHJPf6vCao8Mv9gkLDvBfJCc18kt2C5kk09HBwOCQCjs98XvEtFJhkFRoR9874Mtknt0036fHKMMh"
            )
        }

}