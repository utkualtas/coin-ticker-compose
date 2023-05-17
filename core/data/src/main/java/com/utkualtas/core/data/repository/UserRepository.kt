package com.utkualtas.core.data.repository

import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface UserRepository {
    val isUserAuthenticated: Boolean
    val userAuthenticatedFlow: StateFlow<Boolean>

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<Unit>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<Unit>

    suspend fun addCoinToFavourites(coin: Coin): Result<Unit>

    suspend fun removeCoinFromFavourites(coin: Coin): Result<Unit>

    fun getFavouritesFlow(): Flow<List<Coin>>
}