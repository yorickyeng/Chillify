package com.vk.chillify.presentation.screens.library_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vk.chillify.domain.entity.Album
import com.vk.chillify.domain.entity.Artist
import com.vk.chillify.presentation.screens.home_screen.HomeViewModel
import com.vk.chillify.presentation.screens.home_screen.HomeViewModelFactory
import com.vk.chillify.presentation.templates.Header
import com.vk.chillify.presentation.templates.SongCover

@Composable
fun LibraryScreen(
    navController: NavController,
    homeViewModelFactory: HomeViewModelFactory
) {

    val viewModel: HomeViewModel = viewModel(
        factory = homeViewModelFactory
    )

    val artists by viewModel.artists.collectAsState()
    val popularAlbums by viewModel.popularAlbums.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121111))
            .padding(horizontal = 10.dp)
    ) {
        Header(navController)
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Your Library",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        if (popularAlbums.isNotEmpty() && artists.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                horizontalArrangement =Arrangement.spacedBy(10.dp)
            ) {
                items(popularAlbums + artists) { albumOrArtist ->
                    when (albumOrArtist) {
                        is Artist -> {
                            SongCover(
                                navController = navController,
                                artistName = albumOrArtist.artistName,
                                imageUrl = albumOrArtist.artistImageUrl,
                                albumName = "",
                                albumOrArtistUrl = albumOrArtist.artistUrl
                            )
                        }

                        is Album -> {
                            SongCover(
                                navController = navController,
                                artistName = albumOrArtist.artist.artistName,
                                imageUrl = albumOrArtist.albumImageUrl,
                                albumName = "",
                                albumOrArtistUrl = albumOrArtist.albumUrl
                            )
                        }

                        else -> {
                            println("why")
                        }
                    }
                }
            }
        }

        else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Sorry, no connection (just turn on VPN)",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}