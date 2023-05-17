package com.utkualtas.feature.favourite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.utkualtas.core.ui.theme.CoinTickerTheme

@Composable
fun FavouritesScreen(
    state: FavouritesUIState,
    onNavigateToLogin: () -> Unit,
) {

    LaunchedEffect(state.isAuthenticated) {
        if (!state.isAuthenticated) onNavigateToLogin()
    }

}

@Preview
@Composable
private fun FavouritesScreenPreview() {
    CoinTickerTheme {
        val state = FavouritesUIState(isAuthenticated = false)
        FavouritesScreen(state = state, onNavigateToLogin = { })
    }
}