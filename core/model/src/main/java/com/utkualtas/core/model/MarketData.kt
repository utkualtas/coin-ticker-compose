package com.utkualtas.core.model

data class MarketData(
    val currentPrice: Map<String, Double>,
    val priceChangePercentage24HinCurrency: Map<String, Double>,
)