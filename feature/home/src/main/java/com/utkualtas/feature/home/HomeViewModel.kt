package com.utkualtas.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utkualtas.core.data.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
) : ViewModel() {

    private val mUIState = MutableStateFlow(HomeUIState())
    val uIState: StateFlow<HomeUIState> = mUIState.asStateFlow()

    init {
        collectCoins()
        fetchCoins()
    }

    fun onSearchQueryChange(query: String) = viewModelScope.launch {
        mUIState.update { it.copy(searchQuery = query) }
    }

    private fun collectCoins() = coinRepository.getCoinsFlow()
        .onEach { coins -> mUIState.update { it.copy(coins = coins) } }
        .launchIn(viewModelScope)

    private fun fetchCoins() = viewModelScope.launch {
        coinRepository.fetchCoins()
    }

}