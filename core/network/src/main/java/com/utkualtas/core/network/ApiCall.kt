package com.utkualtas.core.network

import com.utkualtas.core.common.di.IoDispatcher
import com.utkualtas.core.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiCall @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) {

    suspend operator fun <T> invoke(
        call: suspend () -> T,
    ): Result<T?> = withContext(ioDispatcher) {
        try {
            val response = call()
            Result.Success(response)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}
