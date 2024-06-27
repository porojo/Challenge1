package repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import model.Product
import org.porojo.moneyswift.source.source.ProductSource

class ProductRepoImpl(
    private val productSource: ProductSource,
    private val coroutineDispatcher: CoroutineDispatcher
) : ProductRepo {
    override suspend fun getListOfProducts(): Flow<List<Product>> {
        return withContext(context = coroutineDispatcher) {
            productSource.getProducts().map { productList ->
                productList.map { product ->
                    Product(
                        productId = product.productId,
                        productName = product.productName,
                        productPrice = product.productPrice,
                        productThumbnail = product.productThumbnail
                    )
                }
            }
        }
    }
}
