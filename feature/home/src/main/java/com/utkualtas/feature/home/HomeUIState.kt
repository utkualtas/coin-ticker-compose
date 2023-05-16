package com.utkualtas.feature.home

import com.utkualtas.core.model.Coin

data class HomeUIState(
    private val coins: List<Coin> = emptyList(),
    val searchQuery: String = "",
) {

    val filteredCoins: List<Coin>
        get() = coins.filter { coin ->
            coin.name.contains(searchQuery, ignoreCase = true) ||
                    coin.symbol.contains(searchQuery, ignoreCase = true)
        }

}