package com.utkualtas.feature.favourite

import com.utkualtas.core.model.Coin

data class FavouritesUIState(
    val coins: List<Coin> = emptyList(),
    val isAuthenticated: Boolean,
)