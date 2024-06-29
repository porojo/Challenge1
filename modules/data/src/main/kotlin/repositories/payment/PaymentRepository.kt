package repositories.payment

import model.PaymentDomain

interface PaymentRepository {

    suspend fun getPaymentInfo(amount: Long, currency: String): PaymentDomain?

}