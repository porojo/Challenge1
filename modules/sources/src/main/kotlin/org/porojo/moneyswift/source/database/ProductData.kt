package org.porojo.moneyswift.source.database

import org.porojo.moneyswift.domain.R
import org.porojo.moneyswift.source.model.ProductEntity

object ProductData {
    val productEntityLists = listOf(
        ProductEntity(
            productId = 1,
            productThumbnail = R.drawable.google_pixel_8_pro,
            productName = "Google Pixel 8 Pro",
            productPrice = 98000
        ),
        ProductEntity(
            productId = 2,
            productThumbnail = R.drawable.google_pixel_buds_pro,
            productName = "Google Pixel Buds Pro",
            productPrice = 23500
        ),
        ProductEntity(
            productId = 3,
            productThumbnail = R.drawable.google_pixel_tablet,
            productName = "Google Pixel Tablet",
            productPrice = 95000
        ),
        ProductEntity(
            productId = 4,
            productThumbnail = R.drawable.google_pixel_watch_2,
            productName = "Google Pixel Watch 2",
            productPrice = 77000
        )
    )
}