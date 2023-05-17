package com.utkualtas.feature.coin_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utkualtas.core.data.repository.CoinRepository
import com.utkualtas.core.data.repository.UserRepository
import com.utkualtas.core.model.onSuccess
import com.utkualtas.feature.coin_detail.model.SingleMarketData
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
class CoinDetailViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
    private val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val coinId: String = CoinDetailArgs(savedStateHandle).coinId

    private val mUIState = MutableStateFlow(CoinDetailUIState())
    val uIState: StateFlow<CoinDetailUIState> = mUIState.asStateFlow()

    init {
        getCoinDetail()
        collectAuthStatus()
    }

    private fun collectAuthStatus() = userRepository.userAuthenticatedFlow
        .onEach { isAuthenticated ->
            mUIState.update { state -> state.copy(isAuthenticated = isAuthenticated) }
            if (isAuthenticated) collectFavourites()
        }
        .launchIn(viewModelScope)

    fun onRefresh() = getCoinDetail()

    fun onIncreaseRefreshRate() {
        val currentRate = mUIState.value.refreshRateInSecond
        mUIState.update { it.copy(refreshRateInSecond = currentRate + 1) }
    }

    fun onDecreaseRefreshRate() {
        val currentRate = mUIState.value.refreshRateInSecond
        if (currentRate < 2) return
        mUIState.update { it.copy(refreshRateInSecond = currentRate - 1) }
    }

    fun onFavouriteClick() = viewModelScope.launch {
        val coin = mUIState.value.coin ?: return@launch
        when (mUIState.value.isFavourite) {
            true -> userRepository.removeCoinFromFavourites(coin)
            false -> userRepository.addCoinToFavourites(coin)
        }
    }

    private fun getCoinDetail() = viewModelScope.launch {
        coinRepository.getCoinDetail(coinId).onSuccess { coin ->
            val marketData = coin.marketData?.currentPrice?.map {
                SingleMarketData(
                    name = it.key,
                    currentPrice = it.value.toString(),
                    priceChangePercentage24H = coin.marketData
                        ?.priceChangePercentage24HinCurrency
                        ?.getOrDefault(it.key, "-")
                        .toString()
                )
            }.orEmpty()

            mUIState.update { state ->
                state.copy(
                    coin = coin,
                    marketData = marketData,
                )
            }
        }
    }

    private fun collectFavourites() = userRepository.getFavouritesFlow()
        .onEach { favourites ->
            val isFavourite = favourites.any { it.id == coinId }
            mUIState.update { it.copy(isFavourite = isFavourite) }
        }
        .launchIn(viewModelScope)

}
