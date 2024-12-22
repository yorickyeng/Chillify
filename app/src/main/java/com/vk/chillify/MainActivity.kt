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
import com.vk.chillify.presentation.library_screen.LibraryScreen
import com.vk.chillify.presentation.search_screen.SearchScreen
import com.vk.chillify.presentation.songFull_screen.SongFullScreen
import com.vk.chillify.presentation.templates.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
                    composable("Home") { HomeScreen() }
                    composable("Search") { SearchScreen() }
                    composable("Library") { LibraryScreen() }
                    composable("song_fullscreen") { SongFullScreen() }
                }
            }
        }
    }
}