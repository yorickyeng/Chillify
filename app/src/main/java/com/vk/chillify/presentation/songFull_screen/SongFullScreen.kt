package com.vk.chillify.presentation.songFull_screen

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vk.chillify.R
import com.vk.chillify.presentation.viewModels.MusicViewModel
import java.io.File

//@Preview(showSystemUi = true)
@Composable
fun SongFullScreen(
    viewModel: MusicViewModel = viewModel(),
    songName: String = "Song name",
    authorName: String = "Author name",
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121111))
    )
    {
        val isPlaying by viewModel.isPlaying.collectAsState()
        val context = LocalContext.current
        Image(
            painter = painterResource(R.drawable.chill_headphones_guy),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .padding(horizontal = 40.dp, vertical = 60.dp)
        )

        Track(songName, authorName)

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,


            )
        {
            IconButton(onClick = { }) {

                Icon(
                    painter = painterResource(R.drawable.previous),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
            IconButton(onClick = { viewModel.playPause() }) {

                Icon(
                    painter = if (!isPlaying) painterResource(R.drawable.play) else painterResource(
                        R.drawable.pause
                    ),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
            IconButton(onClick = { }) {

                Icon(
                    painter = painterResource(R.drawable.next),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
        IconButton(onClick = { shareName(songName, context) }) {
            Icon(
                painter = painterResource(R.drawable.share),
                contentDescription = "share",
                tint = Color.White,
                modifier = Modifier.size(70.dp)
            )
        }

//        IconButton(onClick = { shareSong(context) }) {
//            Icon(
//                painter = painterResource(R.drawable.share),
//                contentDescription = "share",
//                tint = Color.White,
//                modifier = Modifier.size(70.dp)
//            )
//        }

    }
}


fun shareName(track: String, context: Context) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, track)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, "Share Song Name!")
    context.startActivity(shareIntent)
}

fun shareSong(context: Context){
    val uri = Uri.parse("android.resource://${context.packageName}/raw/track1")

    val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND

        putExtra(Intent.EXTRA_STREAM, uri)
        type = "audio/mp3"
    }

    context.startActivity(Intent.createChooser(shareIntent, "Share Song mp3"))
}

fun shareSong1(context: Context){
    val fileName = "track1.mp3"
    val cacheFile = File(context.cacheDir, fileName)

    val uri: Uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        cacheFile
    )

    val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND

        putExtra(Intent.EXTRA_STREAM, uri)
        type = "audio/*"
    }

    context.startActivity(Intent.createChooser(shareIntent, "Share Song mp3"))
}

@Composable
fun Track(songName: String, authorName: String) {
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
                    text = songName,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = authorName,
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

        }
    }

}