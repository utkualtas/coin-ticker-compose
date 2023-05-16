package com.utkualtas.core.network.model

import com.utkualtas.core.model.MarketData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMarketData(
    @SerialName("current_price")
    val currentPrice: Map<String, Double>? = null,
    @SerialName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24HinCurrency: Map<String, Double>? = null,
)

internal fun NetworkMarketData.asExternal(): MarketData = MarketData(
    currentPrice = currentPrice.orEmpty(),
    priceChangePercentage24HinCurrency = priceChangePercentage24HinCurrency.orEmpty()
)