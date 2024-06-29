package model

import org.porojo.moneyswift.source.model.PaymentDTO

data class PaymentDomain(
    val paymentIntent: String,
    val ephemeralKey: String,
    val customer: String,
    val publishableKey: String,
)

fun PaymentDTO.toDomain() = PaymentDomain(
    paymentIntent = paymentIntent,
    ephemeralKey = ephemeralKey,
    customer = customer,
    publishableKey = publishableKey
)

fun PaymentDomain.toDTO() = PaymentDTO(
    paymentIntent = paymentIntent,
    ephemeralKey = ephemeralKey,
    customer = customer,
    publishableKey = publishableKey
)
