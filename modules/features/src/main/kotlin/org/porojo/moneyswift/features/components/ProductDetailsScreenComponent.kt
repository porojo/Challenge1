package org.porojo.moneyswift.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import model.Product

@Composable
fun ProductDetailsScreenComponent(product: Product, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Image(
            modifier = Modifier.fillMaxWidth().size(400.dp),
            painter = painterResource(product.productThumbnail),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Name: ${product.productName}",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Price: Kes ${product.productPrice}",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        ){
            Text("Buy")
        }
    }

}