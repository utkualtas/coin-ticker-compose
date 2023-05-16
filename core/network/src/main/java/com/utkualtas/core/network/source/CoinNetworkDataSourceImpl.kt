package com.utkualtas.core.network.source

import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import com.utkualtas.core.model.mapData
import com.utkualtas.core.model.requireNonNull
import com.utkualtas.core.network.ApiCall
import com.utkualtas.core.network.api.CoinApi
import com.utkualtas.core.network.model.NetworkCoin
import com.utkualtas.core.network.model.asExternal
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class CoinNetworkDataSourceImpl @Inject constructor(
    private val apiCall: ApiCall,
    private val coinApi: CoinApi,
) : CoinNetworkDataSource {

    override suspend fun getCoins(): Result<List<Coin>> {
        return apiCall { coinApi.getCoins() }
            .mapData { networkCoins -> networkCoins?.map(NetworkCoin::asExternal).orEmpty() }
    }

    override suspend fun getCoinDetail(id: String): Result<Coin> {
        return apiCall { coinApi.getCoinDetail(id) }
            .requireNonNull()
            .mapData(NetworkCoin::asExternal)
    }

}