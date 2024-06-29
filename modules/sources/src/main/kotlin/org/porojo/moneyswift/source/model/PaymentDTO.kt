package org.porojo.moneyswift.source.model

data class PaymentDTO(
    val paymentIntent: String,
    val ephemeralKey: String,
    val customer: String,
    val publishableKey: String,
)