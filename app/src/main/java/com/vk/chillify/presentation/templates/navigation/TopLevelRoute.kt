package com.vk.chillify.presentation.templates.navigation

import com.vk.chillify.R

val topLevelRoutes = listOf(
    TopLevelRoute("Home", "Home", R.drawable.home),
    TopLevelRoute("Search", "Search", R.drawable.search),
    TopLevelRoute("Library", "Library", R.drawable.library),
)

data class TopLevelRoute(
    val label: String, val route: String, val icon: Int
)
