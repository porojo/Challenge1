package repositories.payment

import model.PaymentDomain
import model.toDomain
import org.porojo.moneyswift.source.source.payment.PaymentSource

class PaymentRepositoryImpl(
    private val remoteSource: PaymentSource
) : PaymentRepository {
    override suspend fun getPaymentInfo(amount: Long, currency: String): PaymentDomain? =
        remoteSource
            .fetchPaymentInfo(amount = amount, currency = currency)
            ?.toDomain()
}
