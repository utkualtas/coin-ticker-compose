package com.utkualtas.core.network.model

import com.utkualtas.core.model.Coin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCoin(
    val id: String,
    val name: String? = null,
    val symbol: String? = null,
    @SerialName("hashing_algorithm") val hashingAlgorithm: String? = null,
    val description: Map<String, String>? = null,
    val image: NetworkImage? = null,
    @SerialName("market_data")
    val marketData: NetworkMarketData? = null,
)

internal fun NetworkCoin.asExternal(): Coin = Coin(
    id = id,
    name = name.orEmpty(),
    symbol = symbol.orEmpty(),
    hashingAlgorithm = hashingAlgorithm.orEmpty(),
    description = description.orEmpty(),
    image = image?.asExternal(),
    marketData = marketData?.asExternal(),
)
