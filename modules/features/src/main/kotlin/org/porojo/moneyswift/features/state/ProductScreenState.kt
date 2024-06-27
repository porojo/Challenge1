package org.porojo.moneyswift.features.state

sealed class ProductScreenState<out T> {

    data object Loading : ProductScreenState<Nothing>()

    data class Success<T>(val data: T) : ProductScreenState<T>()

    data class Error(val message: String) : ProductScreenState<Nothing>()

}