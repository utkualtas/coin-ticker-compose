package com.utkualtas.core.database.source

import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import kotlinx.coroutines.flow.Flow

interface CoinLocalDataSource {
    fun getAllCoins(): List<Coin>
    fun getAllCoinsFlow(): Flow<List<Coin>>
    suspend fun insertCoins(coins: List<Coin>): Result<Unit>
}