package org.porojo.moneyswift.source.database

import org.porojo.moneyswift.domain.R
import org.porojo.moneyswift.source.model.ProductEntity

object ProductData {
    val productEntityLists = listOf(
        ProductEntity(
            productId = 1,
            productThumbnail = R.drawable.a5,
            productName = "Audi A5",
            productPrice = 49000
        ),
        ProductEntity(
            productId = 2,
            productThumbnail = R.drawable.a7,
            productName = "Audi A7",
            productPrice = 77000
        ),
        ProductEntity(
            productId = 3,
            productThumbnail = R.drawable.q8,
            productName = "Audi Q8",
            productPrice = 77777
        ),
        ProductEntity(
            productId = 4,
            productThumbnail = R.drawable.rs5,
            productName = "Audi RS5",
            productPrice = 84000
        ),
        ProductEntity(
            productId = 5,
            productThumbnail = R.drawable.rs7,
            productName = "Audi RS7",
            productPrice = 140000
        ),
        ProductEntity(
            productId = 6,
            productThumbnail = R.drawable.s7,
            productName = "Audi S7",
            productPrice = 91000
        ),
        ProductEntity(
            productId = 7,
            productThumbnail = R.drawable.s8,
            productName = "Audi S8",
            productPrice = 123456
        )
    )
}