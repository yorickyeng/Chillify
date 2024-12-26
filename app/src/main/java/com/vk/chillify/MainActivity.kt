package com.vk.chillify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vk.chillify.presentation.screens.home_screen.HomeScreen
import com.vk.chillify.presentation.screens.home_screen.HomeViewModelFactory
import com.vk.chillify.presentation.screens.information_screen.InformationScreen
import com.vk.chillify.presentation.screens.library_screen.LibraryScreen
import com.vk.chillify.presentation.screens.notifications_screen.NotificationsScreen
import com.vk.chillify.presentation.screens.search_screen.SearchScreen
import com.vk.chillify.presentation.screens.settings_screen.SettingsScreen
import com.vk.chillify.presentation.screens.song_full_screen.SongFullScreen
import com.vk.chillify.presentation.templates.navigation.BottomNavigationBar
import com.vk.chillify.presentation.templates.navigation.Routes
import com.vk.chillify.presentation.viewModels.MusicViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApp).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        val musicViewModel = MusicViewModel(application = application)

        setContent {
            val navController = rememberNavController()

            Scaffold(bottomBar = {
                BottomNavigationBar(
                    navController, musicViewModel
                )
            }) { innerPadding ->
                NavHost(
                    navController,
                    startDestination = "Home",
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    composable(Routes.Home.route) {
                        HomeScreen(
                            navController, homeViewModelFactory
                        )
                    }
                    composable(Routes.Search.route) { SearchScreen(navController) }
                    composable(Routes.Library.route) {
                        LibraryScreen(
                            navController,
                            homeViewModelFactory
                        )
                    }
                    composable(Routes.Settings.route) { SettingsScreen() }
                    composable(Routes.Notifications.route) { NotificationsScreen() }
                    composable(Routes.SongFullScreen.route) { SongFullScreen(musicViewModel) }
                    composable(
                        route = Routes.Information.route,
                        arguments = listOf(navArgument("imageUrl") { type = NavType.StringType },
                            navArgument("artistName") { type = NavType.StringType },
                            navArgument("albumName") { type = NavType.StringType },
                            navArgument("albumOrArtistUrl") {
                                type = NavType.StringType
                            })
                    ) { backStackEntry ->
                        val imageUrl = backStackEntry.arguments?.getString("imageUrl").orEmpty()
                        val artistName = backStackEntry.arguments?.getString("artistName").orEmpty()
                        val albumName = backStackEntry.arguments?.getString("albumName").orEmpty()
                        val albumOrArtistUrl =
                            backStackEntry.arguments?.getString("albumOrArtistUrl").orEmpty()

                        InformationScreen(
                            imageUrl = imageUrl,
                            artistName = artistName,
                            albumName = albumName,
                            albumOrArtistUrl = albumOrArtistUrl
                        )
                    }
                }
            }
        }
    }
}