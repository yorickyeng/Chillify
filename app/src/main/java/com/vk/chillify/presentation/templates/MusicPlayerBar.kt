package com.vk.chillify.presentation.templates

import android.media.MediaPlayer
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    onClick: () -> Unit = {},
    mMediaPlayer: MediaPlayer

) {
    val isPlaying = remember { mutableStateOf(false) }

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

            IconButton(onClick = { onFavoriteClick() }) {
                Icon(
                    imageVector = if(!favourite) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                    contentDescription = "favourite",
                    tint = Color.White
                )
            }

            // Play/Pause Button
            IconButton(onClick = { player(isPlaying, mMediaPlayer) }) {
                Icon(
                    imageVector = if (isPlaying.value) Icons.Filled.Close else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying.value) "Pause" else "Play",
                    tint = Color.White
                )
            }
        }
    }
}

fun player(isPlaying: MutableState<Boolean>, mMediaPlayer: MediaPlayer){
    isPlaying.value = !isPlaying.value
    if (isPlaying.value){
        mMediaPlayer.start()
    }
    else{
        mMediaPlayer.pause()
    }
}

fun onFavoriteClick(){

}
