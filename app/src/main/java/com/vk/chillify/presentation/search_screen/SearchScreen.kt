package com.vk.chillify.presentation.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vk.chillify.presentation.home_screen.HomeViewModel
import com.vk.chillify.presentation.home_screen.HomeViewModelFactory
import com.vk.chillify.presentation.templates.Header
import com.vk.chillify.presentation.templates.HorizontalFramesRow
import com.vk.chillify.presentation.templates.SongCover
import com.vk.chillify.presentation.templates.SongsSection

@Composable
fun SearchScreen(navController: NavController, homeViewModelFactory: HomeViewModelFactory) {

    val viewModel: HomeViewModel = viewModel(
        factory = homeViewModelFactory
    )
    val artist by viewModel.artist.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121111))
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {
            item { Header(navController) }
            item { SongsSection("Search)))))", artist.artistName, artist.artistImageUrl) }
            repeat(10) {
                item { HorizontalFramesRow { SongCover(artist.artistName, artist.artistImageUrl) } }
            }
        }
    }
}