package org.porojo.moneyswift.source.source.payment

import org.porojo.moneyswift.source.model.PaymentDTO

interface PaymentSource {

    suspend fun fetchPaymentInfo(amount: Long, currency: String): PaymentDTO?

}