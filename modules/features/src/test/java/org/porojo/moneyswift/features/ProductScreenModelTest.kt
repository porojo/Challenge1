package org.porojo.moneyswift.features

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import model.Product
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.porojo.moneyswift.domain.R
import org.porojo.moneyswift.features.screens.products.ProductScreenModel
import org.porojo.moneyswift.features.state.ScreenUiState
import repositories.ProductRepoImpl

class ProductScreenModelTest {

    private val productRepo = mockk<ProductRepoImpl>(relaxed = true)
    private lateinit var productScreenModel: ProductScreenModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher = Dispatchers.Unconfined)
        productScreenModel = ProductScreenModel(productRepo = productRepo)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetProductsListItems() = runTest {
        val products = listOf(
            Product(
                productId = 1,
                productThumbnail = R.drawable.google_pixel_8_pro,
                productName = "Google Pixel 8 Pro",
                productPrice = 98000
            ),
            Product(
                productId = 2,
                productThumbnail = R.drawable.google_pixel_buds_pro,
                productName = "Google Pixel Buds Pro",
                productPrice = 23500
            ),
            Product(
                productId = 3,
                productThumbnail = R.drawable.google_pixel_tablet,
                productName = "Google Pixel Tablet",
                productPrice = 95000
            ),
            Product(
                productId = 4,
                productThumbnail = R.drawable.google_pixel_watch_2,
                productName = "Google Pixel Watch 2",
                productPrice = 77000
            )
        )
        // Given
        coEvery { productRepo.getListOfProducts() } returns flowOf(value = products)
        // When
        productScreenModel.getProductsListItems()
        coVerify { productRepo.getListOfProducts() }
        // Then
        val productScreenUIState = productScreenModel.state.value
        assertEquals(ScreenUiState.Success(data = products), productScreenUIState.screenUiState)
    }

}