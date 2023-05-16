package com.utkualtas.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.utkualtas.app.ui.app.CoinTickerApp
import com.utkualtas.app.ui.app.rememberCoinTickerAppState
import com.utkualtas.core.ui.theme.CoinTickerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberCoinTickerAppState()
            CoinTickerTheme {
                CoinTickerApp(appState)
            }
        }
    }
}