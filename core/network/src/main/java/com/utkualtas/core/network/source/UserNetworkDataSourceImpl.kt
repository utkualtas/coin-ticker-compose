package com.utkualtas.core.network.source

import com.google.firebase.auth.FirebaseAuth
import com.utkualtas.core.model.Result
import com.utkualtas.core.model.User
import com.utkualtas.core.model.mapData
import com.utkualtas.core.model.requireNonNull
import com.utkualtas.core.network.ApiCall
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@Bound
class UserNetworkDataSourceImpl @Inject constructor(
    private val apiCall: ApiCall,
    private val firebaseAuth: FirebaseAuth,
) : UserNetworkDataSource {
    override fun isUserAuthenticated(): Boolean {
        return firebaseAuth.currentUser != null
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<User> {
        return apiCall { firebaseAuth.createUserWithEmailAndPassword(email, password).await() }
            .requireNonNull()
            .mapData { authUser ->
                User(id = authUser.user?.uid.orEmpty())
            }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Result<User> {
        return apiCall { firebaseAuth.signInWithEmailAndPassword(email, password).await() }
            .requireNonNull()
            .mapData { authUser ->
                User(id = authUser.user?.uid.orEmpty())
            }
    }

}