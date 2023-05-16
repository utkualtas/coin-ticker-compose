package com.utkualtas.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.utkualtas.core.database.dao.CoinDao
import com.utkualtas.core.database.dto.CoinDto

@Database(entities = [CoinDto::class], version = 1)
abstract class CoinTickerDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}