package repositories

import mapper.toDomain
import model.ProductDomain
import org.porojo.moneyswift.source.ProductDAO
import org.porojo.moneyswift.source.products

class ProductRepoImpl(
    private val productDAO: ProductDAO
) : ProductRepo {
    override suspend fun getListOfProducts(): List<ProductDomain> {
        val productList = productDAO.getProducts()
        return products.map { it.toDomain() }
    }
}
