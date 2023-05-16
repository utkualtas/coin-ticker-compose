package com.utkualtas.core.data.repository

import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun fetchCoins(): Result<Unit>
    fun getCoinsFlow(): Flow<List<Coin>>

}