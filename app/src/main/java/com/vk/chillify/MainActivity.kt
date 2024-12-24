package com.vk.chillify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vk.chillify.presentation.home_screen.HomeScreen
import com.vk.chillify.presentation.home_screen.HomeViewModelFactory
import com.vk.chillify.presentation.library_screen.LibraryScreen
import com.vk.chillify.presentation.notifications_screen.NotificationsScreen
import com.vk.chillify.presentation.search_screen.SearchScreen
import com.vk.chillify.presentation.settings_screen.SettingsScreen
import com.vk.chillify.presentation.songFull_screen.SongFullScreen
import com.vk.chillify.presentation.templates.navigation.BottomNavigationBar
import com.vk.chillify.presentation.templates.navigation.Routes
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApp).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Scaffold(bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
                NavHost(
                    navController,
                    startDestination = "Home",
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    composable(Routes.Home.route) { HomeScreen(navController, homeViewModelFactory) }
                    composable(Routes.Search.route) { SearchScreen(navController, homeViewModelFactory) }
                    composable(Routes.Library.route) { LibraryScreen(navController) }
                    composable(Routes.Settings.route) { SettingsScreen() }
                    composable(Routes.Notifications.route) { NotificationsScreen() }
                    composable(Routes.SongFullScreen.route) { SongFullScreen() }
                }
            }
        }
    }
}