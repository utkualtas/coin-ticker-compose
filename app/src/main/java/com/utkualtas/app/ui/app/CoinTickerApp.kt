package com.utkualtas.app.ui.app

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.utkualtas.app.navigation.CoinTickerNavHost
import com.utkualtas.core.ui.component.CoinTickerTopAppBar

@Composable
fun rememberCoinTickerAppState(
    navController: NavHostController = rememberNavController(),
): CoinTickerAppState {
    return remember(navController) {
        CoinTickerAppState(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinTickerApp(
    appState: CoinTickerAppState = rememberCoinTickerAppState(),
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            val navigationIcon = when (appState.showNavigationIcon) {
                true -> Icons.Filled.ArrowBack
                false -> null
            }

            CoinTickerTopAppBar(
                title = appState.appBarTitle,
                navigationIcon = navigationIcon,
                onNavigationIconClick = appState::onBackClick
            )
        }
    ) { innerPaddings ->
        CoinTickerNavHost(
            modifier = Modifier
                .padding(innerPaddings)
                .imePadding(),
            navController = appState.navController,
            onBackClick = appState::onBackClick
        )
    }
}






