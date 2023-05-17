package com.utkualtas.app.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.utkualtas.feature.authentication.authenticationRoute
import com.utkualtas.feature.coin_detail.coinDetailRoute
import com.utkualtas.feature.favourite.favouritesRoute
import com.utkualtas.feature.home.homeRoute
import com.utkualtas.feature.home.navigateHome

@Stable
data class CoinTickerAppState(val navController: NavHostController) {

    private val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination


    val appBarTitle: String
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> "Home"
            favouritesRoute -> "My Coins"
            authenticationRoute -> "Login & Register"
            coinDetailRoute() -> "Detail"
            else -> ""
        }

    val showNavigationIcon: Boolean
        @Composable get() = when (currentDestination?.route) {
            coinDetailRoute() -> true
            authenticationRoute -> true
            else -> false
        }

    val showBottomBar: Boolean
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> true
            favouritesRoute -> true
            else -> false
        }

    fun onBackClick() {
        navController.popBackStack()
    }

    fun onNavigationIconClick() {
        when (navController.currentDestination?.route) {
            authenticationRoute -> navController.navigateHome()
            else -> onBackClick()
        }
    }

}