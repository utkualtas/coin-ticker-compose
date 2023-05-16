package com.utkualtas.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utkualtas.core.model.Coin
import com.utkualtas.core.ui.theme.CoinTickerTheme

@Composable
fun SingleCoinListItem(
    modifier: Modifier = Modifier,
    coin: Coin,
    onCoinClick: (id: String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
            .clickable { onCoinClick(coin.id) }
            .padding(vertical = 10.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            modifier = Modifier,
            text = coin.symbol.uppercase(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
        )

        Text(
            modifier = Modifier,
            text = coin.name,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}


@Preview
@Composable
private fun SingleCoinListItemPreview() {
    CoinTickerTheme {
        val coin = Coin(
            id = "1",
            name = "Bitcoin",
            symbol = "BTC",
        )
        SingleCoinListItem(coin = coin, onCoinClick = {})
    }
}