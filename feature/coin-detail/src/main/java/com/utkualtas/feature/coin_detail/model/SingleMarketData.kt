package com.utkualtas.feature.coin_detail.model

data class SingleMarketData(
    val name: String,
    val currentPrice: String,
    val priceChangePercentage24H: String,
)