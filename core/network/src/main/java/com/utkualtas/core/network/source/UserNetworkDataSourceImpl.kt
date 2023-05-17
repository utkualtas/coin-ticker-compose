package com.utkualtas.core.network.source

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObject
import com.utkualtas.core.model.Coin
import com.utkualtas.core.model.Result
import com.utkualtas.core.model.User
import com.utkualtas.core.model.mapData
import com.utkualtas.core.model.requireNonNull
import com.utkualtas.core.network.ApiCall
import com.utkualtas.core.network.model.NetworkUser
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Bound
class UserNetworkDataSourceImpl @Inject constructor(
    private val apiCall: ApiCall,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
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


    override suspend fun addCoinToFavourites(coin: Coin): Result<Unit> =
        suspendCoroutine { continuation ->
            val simpleCoin = hashMapOf(
                "id" to coin.id,
                "name" to coin.name,
                "symbol" to coin.symbol,
            )

            val userId = firebaseAuth.currentUser?.uid
                ?: return@suspendCoroutine continuation.resume(Result.error("User not found!"))
            firestore.collection("user").document(userId)
                .update("favs", FieldValue.arrayUnion(simpleCoin))
                .addOnSuccessListener { continuation.resume(Result.success()) }
                .addOnFailureListener { continuation.resume(Result.Error(it)) }
        }

    override suspend fun removeCoinFromFavourites(coin: Coin): Result<Unit> =
        suspendCoroutine { continuation ->
            val simpleCoin = hashMapOf(
                "id" to coin.id,
                "name" to coin.name,
                "symbol" to coin.symbol,
            )

            val userId = firebaseAuth.currentUser?.uid
                ?: return@suspendCoroutine continuation.resume(Result.error("User not found!"))
            firestore.collection("user").document(userId)
                .update("favs", FieldValue.arrayRemove(simpleCoin))
                .addOnSuccessListener { continuation.resume(Result.success()) }
                .addOnFailureListener { continuation.resume(Result.Error(it)) }
        }

    override fun getFavouritesInRealTime(): Flow<List<Coin>> {
        val userId = firebaseAuth.currentUser?.uid ?: return emptyFlow()
        return firestore.collection("user").document(userId).snapshots().map {
            it.toObject<NetworkUser>()?.favs.orEmpty()
        }
    }

}