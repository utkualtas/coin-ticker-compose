package com.utkualtas.core.data.repository

import com.utkualtas.core.model.Result
import com.utkualtas.core.model.onSuccess
import com.utkualtas.core.model.toUnit
import com.utkualtas.core.network.source.UserNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Bound
@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource,
) : UserRepository {

    private val mUserAuthenticatedFlow = MutableStateFlow(isUserAuthenticated)

    override val isUserAuthenticated: Boolean
        get() = userNetworkDataSource.isUserAuthenticated()


    override val userAuthenticatedFlow: StateFlow<Boolean>
        get() = mUserAuthenticatedFlow.asStateFlow()


    override suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<Unit> {
        return userNetworkDataSource.signUpWithEmailAndPassword(email, password)
            .onSuccess { mUserAuthenticatedFlow.emit(true) }
            .toUnit()
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Result<Unit> {
        return userNetworkDataSource.signInWithEmailAndPassword(email, password)
            .onSuccess { mUserAuthenticatedFlow.emit(true) }
            .toUnit()
    }


}