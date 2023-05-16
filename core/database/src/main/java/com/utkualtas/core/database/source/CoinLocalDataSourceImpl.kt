package com.utkualtas.core.database.source

import com.utkualtas.core.database.DbCall
import com.utkualtas.core.database.dao.CoinDao
import com.utkualtas.core.database.dto.CoinDto
import com.utkualtas.core.database.dto.asExternal
import com.utkualtas.core.database.dto.asInternal
import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import com.utkualtas.core.model.toUnit
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Bound
class CoinLocalDataSourceImpl @Inject constructor(
    private val coinDao: CoinDao,
    private val dbCall: DbCall,
) : CoinLocalDataSource {

    override fun getAllCoins(): List<Coin> {
        return coinDao.getAllCoins().map(CoinDto::asExternal)
    }

    override fun getAllCoinsFlow(): Flow<List<Coin>> {
        return coinDao.getAllCoinsFlow().map {
            it.map(CoinDto::asExternal)
        }
    }

    override suspend fun insertCoins(coins: List<Coin>): Result<Unit> {
        return dbCall { coinDao.insertAll(coins.map(Coin::asInternal)) }.toUnit()
    }

}