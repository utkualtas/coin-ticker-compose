package com.utkualtas.feature.coin_detail.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.theme.CoinTickerTheme

@Composable
fun CoinInfo(
    modifier: Modifier = Modifier,
    name: String,
    hashingAlgorithm: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Text(
            modifier = Modifier,
            text = name.uppercase(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
        )

        AnimatedVisibility(visible = hashingAlgorithm.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Hashing: $hashingAlgorithm",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun CoinInfoPreview() {
    CoinTickerTheme {
        CoinInfo(name = "Bitcoin", hashingAlgorithm = "SHA256")
    }
}