package com.utkualtas.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.utkualtas.core.database.dto.CoinDto
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coins")
    fun getAllCoins(): List<CoinDto>

    @Query("SELECT * FROM coins")
    fun getAllCoinsFlow(): Flow<List<CoinDto>>

    @Insert
    fun insertAll(coins: List<CoinDto>)

}