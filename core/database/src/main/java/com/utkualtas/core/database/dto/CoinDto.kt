package com.utkualtas.core.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.MarketData

@Entity(tableName = "coins")
data class CoinDto(
    @PrimaryKey val id: String,
    @ColumnInfo("name") val name: String?,
    @ColumnInfo("symbol") val symbol: String?,
)

internal fun CoinDto.asExternal(): Coin = Coin(
    id = id,
    name = name.orEmpty(),
    symbol = symbol.orEmpty(),
    hashingAlgorithm = "",
    description = emptyMap(),
    marketData = MarketData(emptyMap(), emptyMap()),
    image = null,
)

internal fun Coin.asInternal(): CoinDto = CoinDto(
    id = id,
    name = name,
    symbol = symbol,
)