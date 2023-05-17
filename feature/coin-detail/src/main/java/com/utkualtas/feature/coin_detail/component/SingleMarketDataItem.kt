package com.utkualtas.feature.coin_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.theme.CoinTickerTheme
import com.utkualtas.feature.coin_detail.model.SingleMarketData

@Composable
fun SingleMarketDataItem(
    modifier: Modifier = Modifier,
    singleMarketData: SingleMarketData,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
            .padding(vertical = 10.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {

        Text(
            modifier = Modifier
                .weight(0.24f)
                .alignByBaseline(),
            text = singleMarketData.name.uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
        )

        Text(
            modifier = Modifier
                .weight(0.38f)
                .alignByBaseline(),
            text = singleMarketData.currentPrice,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
        )

        Text(
            modifier = Modifier
                .weight(0.38f)
                .alignByBaseline(),
            text = singleMarketData.priceChangePercentage24H,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
        )

    }
}

@Preview
@Composable
private fun SingleMarketDataPreview() {
    CoinTickerTheme {
        val data = SingleMarketData(
            name = "USD",
            currentPrice = "27.692",
            priceChangePercentage24H = "4.78"
        )
        SingleMarketDataItem(singleMarketData = data)
    }
}