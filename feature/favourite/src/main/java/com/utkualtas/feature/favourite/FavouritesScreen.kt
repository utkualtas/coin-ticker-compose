package com.utkualtas.feature.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.common.SingleCoinListItem
import com.utkualtas.core.ui.theme.CoinTickerTheme

@Composable
fun FavouritesScreen(
    state: FavouritesUIState,
    onNavigateToLogin: () -> Unit,
    onNavigateToCoinDetail: (id: String) -> Unit,
) {

    LaunchedEffect(state.isAuthenticated) {
        if (!state.isAuthenticated) onNavigateToLogin()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
    ) {
        items(items = state.coins) { coin ->
            SingleCoinListItem(coin = coin, onCoinClick = onNavigateToCoinDetail)
        }
    }

}


@Preview
@Composable
private fun FavouritesScreenPreview() {
    CoinTickerTheme {
        val state = FavouritesUIState(isAuthenticated = false)
        FavouritesScreen(state = state, onNavigateToLogin = { }, onNavigateToCoinDetail = {})
    }
}