package com.utkualtas.feature.coin_detail

import com.utkualtas.core.model.Coin
import com.utkualtas.feature.coin_detail.model.SingleMarketData

data class CoinDetailUIState(
    val coin: Coin? = null,
    val marketData: List<SingleMarketData> = emptyList(),
    val refreshRateInSecond: Int = 5,
) {

    val description: String
        get() = coin?.description?.getOrDefault("en", "").orEmpty()

    val refreshRateInMillisecond: Long
        get() = refreshRateInSecond * 1_000L
}