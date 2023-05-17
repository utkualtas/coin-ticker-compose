package com.utkualtas.core.network.source

import com.utkualtas.core.model.Result
import com.utkualtas.core.model.User

interface UserNetworkDataSource {
    fun isUserAuthenticated(): Boolean

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<User>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<User>
}