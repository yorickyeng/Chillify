package com.vk.chillify.presentation.templates.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vk.chillify.presentation.templates.MusicPlayerBar

@Composable
fun BottomNavigationBar(navController: NavController) {
    Column {

        MusicPlayerBar(
            onClick = {
                navController.navigate(Routes.SongFullScreen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
            },

        )


        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            topLevelRoutes.forEach { topLevelRoute ->
                BottomNavigationItem(
                    modifier = Modifier.background(Color.Black),
                    icon = {
                        val isActive = currentDestination?.route == topLevelRoute.route
                        Icon(
                            painter = painterResource(topLevelRoute.icon),
                            contentDescription = topLevelRoute.label,
                            tint = if (isActive) Color.White else Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        val isActive = currentDestination?.route == topLevelRoute.route
                        Text(
                            topLevelRoute.label,
                            color = if (isActive) Color.White else Color.Gray
                        )
                    },
                    selected = currentDestination?.route == topLevelRoute.route,
                    onClick = {
                        navController.navigate(topLevelRoute.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }

    }

}
