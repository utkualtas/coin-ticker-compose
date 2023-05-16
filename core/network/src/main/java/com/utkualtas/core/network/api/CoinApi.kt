package com.utkualtas.core.network.api

import com.utkualtas.core.network.model.NetworkCoin
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET("coins/list")
    suspend fun getCoins(): List<NetworkCoin>

    @GET("coins/{id}")
    suspend fun getCoinDetail(
        @Path("id") id: String,
        @Query("tickers") tickers: Boolean? = false,
        @Query("market_data") marketData: Boolean? = true,
        @Query("community_data") communityData: Boolean? = false,
        @Query("developer_data") developerData: Boolean? = false,
        @Query("sparkline") sparkline: Boolean? = false,
    ): NetworkCoin

}