package com.vk.chillify.data

import com.vk.chillify.R

data class TopLevelRoute(
    val label: String, val route: String, val icon: Int
)

val topLevelRoutes = listOf(
    TopLevelRoute("Home", "Home", R.drawable.home),
    TopLevelRoute("Search", "Search", R.drawable.search),
    TopLevelRoute("Library", "Library", R.drawable.library),
)