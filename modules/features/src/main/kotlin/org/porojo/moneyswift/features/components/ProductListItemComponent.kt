package org.porojo.moneyswift.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import model.Product

@Composable
fun ProductListItemComponent(
    modifier: Modifier = Modifier,
    product: Product,
    onProductClicked: () -> Unit
) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier.size(width = 240.dp, height = 100.dp).clickable {
            onProductClicked()
        }
    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(start = 16.dp, bottom = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(product.productThumbnail),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Name: ${product.productName}",
                modifier = modifier,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Price: Kes ${product.productPrice}",
                modifier = modifier,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
