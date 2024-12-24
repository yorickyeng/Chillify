package com.vk.chillify.presentation.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vk.chillify.R

@Composable
fun MusicPlayerBar(
    modifier: Modifier = Modifier,
    songTitle: String = "Song Title",
    artist: String = "Artist Name",
    favourite: Boolean = false,
    isPlaying: Boolean = false,
    onFavoriteClick: () -> Unit = {},  //  передать лямбды для взаимодействия, по умол. пустые
    onPlayPauseClick: () -> Unit = {},
    onClick: () -> Unit = {},
) {

    Box(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.DarkGray)
            .clickable { onClick() }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.chill_headphones_guy),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            // Song details
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = songTitle,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = artist,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if(!favourite) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                    contentDescription = "favourite",
                    tint = Color.White
                )
            }

            // Play/Pause Button
            IconButton(onClick = onPlayPauseClick) {
                Icon(
                    imageVector = if (isPlaying) Icons.Filled.Close else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying) "Pause" else "Play",
                    tint = Color.White
                )
            }
        }
    }


}
