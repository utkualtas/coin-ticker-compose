package com.utkualtas.feature.coin_detail

import androidx.lifecycle.ViewModel
import com.utkualtas.core.data.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
) : ViewModel() {

    private val mUIState = MutableStateFlow(CoinDetailUIState())
    val uIState: StateFlow<CoinDetailUIState> = mUIState.asStateFlow()
}
