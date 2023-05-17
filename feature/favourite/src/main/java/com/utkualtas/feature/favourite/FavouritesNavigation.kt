package com.utkualtas.feature.favourite

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val favouritesRoute = "favourites"

fun NavGraphBuilder.favouritesScreen(
    onNavigateToLogin: () -> Unit,
) = composable(
    route = favouritesRoute,
) {
    val viewModel: FavouritesViewModel = hiltViewModel()
    val state by viewModel.uIState.collectAsState()
    FavouritesScreen(
        state = state,
        onNavigateToLogin = onNavigateToLogin,
    )
}