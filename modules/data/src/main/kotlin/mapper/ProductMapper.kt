package mapper

import model.ProductDomain
import org.porojo.moneyswift.source.Product

fun Product.toDomain() = ProductDomain(
    productId = id,
    productName = name,
    productPrice = price
)