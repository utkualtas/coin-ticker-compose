package com.utkualtas.core.network.source

import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result

interface CoinNetworkDataSource {

    suspend fun getCoins(): Result<List<Coin>>

    suspend fun getCoinDetail(id: String): Result<Coin>

}