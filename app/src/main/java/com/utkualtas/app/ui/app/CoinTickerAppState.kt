package com.utkualtas.app.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.utkualtas.feature.coin_detail.coinDetailRoute
import com.utkualtas.feature.home.homeRoute

@Stable
data class CoinTickerAppState(val navController: NavHostController) {

    private val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination


    val appBarTitle: String
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> "Home"
            coinDetailRoute() -> "Detail"
            else -> ""
        }

    val showNavigationIcon: Boolean
        @Composable get() = when (currentDestination?.route) {
            coinDetailRoute() -> true
            else -> false
        }

    fun onBackClick() {
        navController.popBackStack()
    }

}