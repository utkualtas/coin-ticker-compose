package com.utkualtas.feature.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.utkualtas.core.model.Coin
import com.utkualtas.core.ui.DevicePreviews
import com.utkualtas.core.ui.component.CoinTickerAsyncImage
import com.utkualtas.feature.coin_detail.component.CoinInfo
import com.utkualtas.feature.coin_detail.component.marketData
import com.utkualtas.feature.coin_detail.component.refreshRate
import kotlinx.coroutines.delay

@Composable
fun CoinDetailScreen(
    state: CoinDetailUIState,
    onIncreaseRefreshRate: () -> Unit,
    onDecreaseRefreshRate: () -> Unit,
    onRefresh: () -> Unit,
    onFavouriteClick: () -> Unit,
    onNavigateToAuthentication: () -> Unit,
) {

    LaunchedEffect(state.refreshRateInSecond) {
        while (true) {
            delay(state.refreshRateInMillisecond)
            onRefresh()
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CoinInfo(
                    modifier = Modifier.weight(0.64f),
                    name = state.coin?.name.orEmpty(),
                    hashingAlgorithm = state.coin?.hashingAlgorithm.orEmpty(),
                    isFavourite = state.isFavourite,
                    onFavouriteClick = {
                        if (state.isAuthenticated) {
                            onFavouriteClick()
                        } else {
                            onNavigateToAuthentication()
                        }
                    },
                )
                CoinTickerAsyncImage(
                    modifier = Modifier.weight(0.36f),
                    url = state.coin?.image?.large
                )

            }
        }

        item {
            if (state.description.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Description",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = state.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 16,
                )
            }
        }

        refreshRate(
            modifier = Modifier.padding(top = 20.dp),
            refreshRateInSecond = state.refreshRateInSecond,
            onIncreaseRefreshRate = onIncreaseRefreshRate,
            onDecreaseRefreshRate = onDecreaseRefreshRate,
        )

        marketData(
            modifier = Modifier.padding(top = 20.dp),
            marketData = state.marketData
        )

    }
}


@DevicePreviews
@Composable
fun HomeScreenPreview() {
    val state = CoinDetailUIState(
        coin = Coin(
            id = "",
            name = "Bitcoin",
            symbol = "BTC",
            hashingAlgorithm = "SHA256",
            marketData = com.utkualtas.core.model.MarketData(emptyMap(), emptyMap()),
            image = null,
            description = emptyMap(),
        )
    )
    CoinDetailScreen(
        state = state,
        onIncreaseRefreshRate = {},
        onDecreaseRefreshRate = {},
        onRefresh = {},
        onFavouriteClick = {},
        onNavigateToAuthentication = {},
    )
}