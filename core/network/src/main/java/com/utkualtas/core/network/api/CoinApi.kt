package com.utkualtas.core.network.api

import com.utkualtas.core.network.model.NetworkCoin
import retrofit2.http.GET

interface CoinApi {

    @GET("coins/list")
    suspend fun getCoins(): List<NetworkCoin>


}