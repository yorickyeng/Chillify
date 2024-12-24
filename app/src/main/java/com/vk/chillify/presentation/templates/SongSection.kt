package com.vk.chillify.presentation.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.chillify.domain.entity.Album
import com.vk.chillify.domain.entity.Artist

@Composable
fun SongsSection(title: String, albumsOrArtists: List<Any>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
        HorizontalFramesRow(albumsOrArtists = albumsOrArtists)
    }
}

@Composable
fun HorizontalFramesRow(albumsOrArtists: List<Any>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 7.dp)
    ) {
        items(albumsOrArtists) { albumOrArtist ->
            when (albumOrArtist) {
                is Artist -> {
                    SongCover(
                        artistName = albumOrArtist.artistName,
                        artistImageUrl = albumOrArtist.artistImageUrl,
                        artistUrl = albumOrArtist.artistUrl,
                        albumName = "",
                    )
                }

                is Album -> {
                    SongCover(
                        artistName = albumOrArtist.artist.artistName,
                        artistImageUrl = albumOrArtist.albumImageUrl,
                        artistUrl = albumOrArtist.artist.artistUrl,
                        albumName = albumOrArtist.albumName,
                    )
                }

                else -> {
                    println("why")
                }
            }
        }
    }
}