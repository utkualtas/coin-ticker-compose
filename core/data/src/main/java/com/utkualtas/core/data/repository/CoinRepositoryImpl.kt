package com.utkualtas.core.data.repository

import com.utkualtas.core.database.source.CoinLocalDataSource
import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import com.utkualtas.core.model.data
import com.utkualtas.core.model.toUnit
import com.utkualtas.core.network.source.CoinNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Bound
class CoinRepositoryImpl @Inject constructor(
    private val coinNetworkDataSource: CoinNetworkDataSource,
    private val coinLocalDataSource: CoinLocalDataSource,
) : CoinRepository {

    override fun getCoinsFlow(): Flow<List<Coin>> {
        return coinLocalDataSource.getAllCoinsFlow()
    }

    override suspend fun getCoinDetail(id: String): Result<Coin> {
        return coinNetworkDataSource.getCoinDetail(id)
    }

    override suspend fun fetchCoins(): Result<Unit> {
        val networkResult = coinNetworkDataSource.getCoins()
        if (networkResult is Result.Error) return networkResult.toUnit()

        return coinLocalDataSource.insertCoins(networkResult.data.orEmpty())
    }

}