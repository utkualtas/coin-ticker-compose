package com.utkualtas.app.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.utkualtas.feature.favourite.favouritesRoute
import com.utkualtas.feature.home.homeRoute

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        name = "Home",
        route = homeRoute,
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        name = "My Coins",
        route = favouritesRoute,
        icon = Icons.Rounded.Favorite,
    ),
)

@Composable
fun CoinTickerBottomBar(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
    ) {
        bottomNavItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(route = homeRoute) {
                            inclusive = false
                            saveState = true
                        }
                    }
                },
                label = {
                    Text(
                        text = item.name,
                        fontWeight = FontWeight.SemiBold,
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.name} Icon",
                    )
                }
            )
        }
    }
}


