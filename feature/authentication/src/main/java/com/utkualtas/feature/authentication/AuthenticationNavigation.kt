package com.utkualtas.feature.authentication

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val authenticationRoute = "authentication"

fun NavGraphBuilder.authenticationScreen(
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit,
) = composable(
    route = authenticationRoute,
) {
    val viewModel: AuthenticationViewModel = hiltViewModel()
    val state by viewModel.uIState.collectAsState()
    AuthenticationScreen(
        state = state,
        onMessageShown = viewModel::onMessageShown,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onNavigateBack = onNavigateBack,
        onNavigateHome = onNavigateHome,
        onSwitchLoginRegister = viewModel::onSwitchLoginRegister,
        onProceed = viewModel::onProceed,
    )
}

fun NavController.navigateToAuthentication() {
    this.navigate(authenticationRoute)
}
