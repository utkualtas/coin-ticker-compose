package com.utkualtas.core.model

data class Coin(
    val id: String = "",
    val symbol: String = "",
    val name: String = "",
    val hashingAlgorithm: String = "",
    val description: Map<String, String> = emptyMap(),
    val image: Image? = null,
    val marketData: MarketData? = null,
)