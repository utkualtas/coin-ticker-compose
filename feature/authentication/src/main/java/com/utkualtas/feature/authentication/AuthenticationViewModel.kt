package com.utkualtas.feature.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utkualtas.core.data.repository.UserRepository
import com.utkualtas.core.model.onError
import com.utkualtas.core.model.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val mUIState = MutableStateFlow(AuthenticationUIState())
    val uIState: StateFlow<AuthenticationUIState> = mUIState.asStateFlow()

    fun onSwitchLoginRegister() {
        val authType = when (mUIState.value.authType) {
            AuthenticationType.LOGIN -> AuthenticationType.REGISTER
            AuthenticationType.REGISTER -> AuthenticationType.LOGIN
        }
        mUIState.update { it.copy(authType = authType) }
    }

    fun onProceed() = when (mUIState.value.authType) {
        AuthenticationType.LOGIN -> signInWithEmailAndPassword()
        AuthenticationType.REGISTER -> signUpWithEmailAndPassword()

    }

    fun onEmailChange(email: String) {
        mUIState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        mUIState.update { it.copy(password = password) }
    }

    fun onMessageShown() {
        mUIState.update { it.copy(message = null) }
    }

    private fun signUpWithEmailAndPassword() = viewModelScope.launch {
        val email = mUIState.value.email
        val password = mUIState.value.password
        userRepository
            .signUpWithEmailAndPassword(email, password)
            .onError { exception ->
                mUIState.update { it.copy(message = exception.message) }
            }
            .onSuccess {
                mUIState.update { it.copy(navigateBack = true) }
            }
    }

    private fun signInWithEmailAndPassword() = viewModelScope.launch {
        val email = mUIState.value.email
        val password = mUIState.value.password
        userRepository
            .signInWithEmailAndPassword(email, password)
            .onError { exception ->
                mUIState.update { it.copy(message = exception.message) }
            }
            .onSuccess {
                mUIState.update { it.copy(navigateBack = true) }
            }
    }

}