package com.utkualtas.feature.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utkualtas.core.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val mUIState = MutableStateFlow(
        FavouritesUIState(isAuthenticated = userRepository.isUserAuthenticated)
    )
    val uIState: StateFlow<FavouritesUIState> = mUIState.asStateFlow()

    init {
        collectAuthStatus()
    }

    private fun collectAuthStatus() = userRepository.userAuthenticatedFlow
        .onEach { mUIState.update { state -> state.copy(isAuthenticated = it) } }
        .launchIn(viewModelScope)


}