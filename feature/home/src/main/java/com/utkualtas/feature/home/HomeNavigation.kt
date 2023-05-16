package com.utkualtas.feature.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(
    onNavigateToCoinDetail: (coinId: String) -> Unit,
) = composable(
    route = homeRoute,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uIState.collectAsState()
    HomeScreen(
        state = state,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onNavigateToCoinDetail = onNavigateToCoinDetail
    )
}