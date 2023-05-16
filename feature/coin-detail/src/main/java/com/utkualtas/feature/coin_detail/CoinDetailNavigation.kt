package com.utkualtas.feature.coin_detail

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val coinDetailRoute = "coins"
private const val coinDetailPathParam = "coinId"

fun coinDetailRoute(): String {
    return "$coinDetailRoute/{$coinDetailPathParam}"
}

fun coinDetailRoute(taskNumber: String): String {
    return "$coinDetailRoute/$taskNumber"
}

internal class CoinDetailArgs(val coinId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(checkNotNull(savedStateHandle[coinDetailPathParam]) as String)
}

fun NavGraphBuilder.coinDetailScreen() = composable(
    route = coinDetailRoute(),
) {
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val state by viewModel.uIState.collectAsState()
    CoinDetailScreen(
        state = state,
        onRefresh = viewModel::onRefresh,
        onIncreaseRefreshRate = viewModel::onIncreaseRefreshRate,
        onDecreaseRefreshRate = viewModel::onDecreaseRefreshRate
    )
}

fun NavController.navigateToCoinDetail(coinId: String) {
    this.navigate(coinDetailRoute(coinId))
}
