package com.utkualtas.feature.coin_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.utkualtas.core.ui.DevicePreviews

@Composable
fun CoinDetailScreen(
    state: CoinDetailUIState,
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}


@DevicePreviews
@Composable
fun HomeScreenPreview() {
    val state = CoinDetailUIState()
    CoinDetailScreen(state = state)
}