package com.utkualtas.core.network.model

import com.utkualtas.core.model.Coin
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCoin(
    val id: String,
    val name: String? = null,
    val symbol: String? = null,
)


internal fun NetworkCoin.asExternal(): Coin = Coin(
    id = id,
    name = name.orEmpty(),
    symbol = symbol.orEmpty()
)
