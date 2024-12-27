package com.vk.chillify.presentation.templates.navigation

import android.net.Uri
import com.vk.chillify.R

data class TopLevelRoute(
    val label: String, val route: String, val icon: Int
)

val topLevelRoutes = listOf(
    TopLevelRoute("Home", "Home", R.drawable.home),
    TopLevelRoute("Search", "Search", R.drawable.search),
    TopLevelRoute("Library", "Library", R.drawable.library),
)

sealed class Routes(val route: String) {
    data object Home : Routes("Home")
    data object Search : Routes("Search")
    data object Library : Routes("Library")
    data object Settings : Routes("Settings")
    data object Notifications : Routes("Notifications")
    data object SongFullScreen : Routes("SongFullScreen")
    data object Information :
        Routes("InformationScreen/{imageUrl}/{artistName}/{albumName}/{albumOrArtistUrl}") {
        fun createRoute(
            imageUrl: String, artistName: String, albumName: String = "", albumOrArtistUrl: String
        ): String {
            return "InformationScreen/" +
                    "${Uri.encode(imageUrl)}/" +
                    "${Uri.encode(artistName)}/" +
                    "${Uri.encode(albumName)}/" +
                    Uri.encode(albumOrArtistUrl)
        }
    }
}