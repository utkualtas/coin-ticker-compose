package com.utkualtas.core.network.model

import com.utkualtas.core.model.Coin

data class NetworkUser(
    val favs: List<Coin> = emptyList(),
)