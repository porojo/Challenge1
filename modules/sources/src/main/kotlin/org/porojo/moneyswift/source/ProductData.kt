package org.porojo.moneyswift.source

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

val products = listOf(
    Product(id = 1, name = "Earphones", price = 200),
    Product(id = 2, name = "Headphones", price = 2000),
    Product(id = 3, name = "Speaker", price = 5000),
    Product(id = 4, name = "Beats", price = 1000),
    Product(id = 5, name = "Boom", price = 2500),
)