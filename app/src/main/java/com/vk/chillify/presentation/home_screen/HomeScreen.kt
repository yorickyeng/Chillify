package com.vk.chillify.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vk.chillify.R
import com.vk.chillify.presentation.templates.Header
import com.vk.chillify.presentation.templates.HorizontalFramesRow
import com.vk.chillify.presentation.templates.SongsSection

@Composable
fun HomeScreen(navController: NavController, homeViewModelFactory: HomeViewModelFactory) {

    val viewModel: HomeViewModel = viewModel(
        factory = homeViewModelFactory
    )

    val artists by viewModel.artists.collectAsState()
    val popularAlbums by viewModel.popularAlbums.collectAsState()

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
            item {
                SongsSection(
                    title = "Popular Albums",
                    albumsOrArtists = popularAlbums
                )
            }
            item { SpotifyWrappedSection(artists = artists.map { it.artistName to it.artistImageUrl }) }
            item {
                SongsSection(
                    title = "Editor's picks",
                    albumsOrArtists = artists.map { it.artistName to it.artistImageUrl }
                )
            }
        }
    }
}

@Composable
fun SpotifyWrappedSection(artists: List<Pair<String, String>>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.chill_headphones_guy),
            contentDescription = "Spotify Wrapped",
            modifier = Modifier
                .size(58.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = "#SPOTIFYWRAPPED", color = Color(0xFF9C9C9C), fontSize = 10.sp
            )
            Text(
                text = "Your 2021 in review", color = Color.White, fontSize = 26.sp
            )
        }
    }
    HorizontalFramesRow(artists)
}