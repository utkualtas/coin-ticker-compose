package com.utkualtas.feature.coin_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun MarketData(
    modifier: Modifier = Modifier,
    marketData: List<SingleMarketData>,
) {

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                )
                .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {

            Text(
                modifier = Modifier
                    .weight(0.24f)
                    .alignByBaseline(),
                text = "Currency",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 1,
            )

            Text(
                modifier = Modifier
                    .weight(0.38f)
                    .alignByBaseline(),
                text = "Price",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 1,
            )

            Text(
                modifier = Modifier
                    .weight(0.38f)
                    .alignByBaseline(),
                text = "24H (%)",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 1,
            )

        }
        marketData.forEach {
            SingleMarketDataItem(singleMarketData = it)
        }
    }

}


@Preview
@Composable
fun MarketDataPreview() {
    CoinTickerTheme {
        val data = List(8) {
            SingleMarketData(
                name = "BTC",
                currentPrice = "27.600",
                priceChangePercentage24H = "4"
            )
        }
        MarketData(marketData = data)
    }
}