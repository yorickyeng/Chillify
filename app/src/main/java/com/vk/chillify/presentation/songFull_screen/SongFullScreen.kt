package com.vk.chillify.presentation.songFull_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
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

//@Preview(showSystemUi = true)
@Composable
fun SongFullScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF121111)))
    {
        Image(
            painter = painterResource(R.drawable.chill_headphones_guy),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .padding(horizontal = 40.dp, vertical = 60.dp)
        )

        Track()     // TODO : Заглушка, добавить рабочую бизнес-логику

        Row(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,


        )
        {
            IconButton(onClick = { }) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
            IconButton(onClick = { }) {

                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
            IconButton(onClick = { }) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
        }

    }
}

@Composable
fun Track(){
    Box(
       modifier = Modifier
           .wrapContentHeight()
           .fillMaxWidth()
           .background(Color(0xFF121111))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Song details
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Song Title",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Artist Name",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            IconButton({ }) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favourite",
                    tint = Color.White
                )
            }

            // Play/Pause Button
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription =  "Play",
                    tint = Color.White
                )
            }
        }
    }

}