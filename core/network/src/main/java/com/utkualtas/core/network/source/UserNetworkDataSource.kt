package com.utkualtas.core.network.source

import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import com.utkualtas.core.model.User
import kotlinx.coroutines.flow.Flow

interface UserNetworkDataSource {
    fun isUserAuthenticated(): Boolean

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<User>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<User>

    suspend fun addCoinToFavourites(coin: Coin): Result<Unit>
    suspend fun removeCoinFromFavourites(coin: Coin): Result<Unit>
    fun getFavouritesInRealTime(): Flow<List<Coin>>
}