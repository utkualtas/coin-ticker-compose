package com.utkualtas.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.utkualtas.feature.authentication.authenticationScreen
import com.utkualtas.feature.authentication.navigateToAuthentication
import com.utkualtas.feature.coin_detail.coinDetailScreen
import com.utkualtas.feature.coin_detail.navigateToCoinDetail
import com.utkualtas.feature.favourite.favouritesScreen
import com.utkualtas.feature.home.homeRoute
import com.utkualtas.feature.home.homeScreen

const val rootGraphRoute = "root"

@Composable
fun CoinTickerNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = homeRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        route = rootGraphRoute
    ) {

        authenticationScreen(onNavigateBack = onBackClick)
        homeScreen(onNavigateToCoinDetail = navController::navigateToCoinDetail)
        favouritesScreen(onNavigateToLogin = navController::navigateToAuthentication)
        coinDetailScreen()
    }


}