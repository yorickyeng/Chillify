package com.vk.chillify.presentation.templates

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import com.vk.chillify.R

@Composable
fun SongCover(artistName: String, artistImageUrl: String,  artistUrl: String, albumName: String = "") {
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        GlideImage(
            imageModel = { artistImageUrl },
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            },
            modifier = Modifier
                .size(154.dp)
                .clip(RoundedCornerShape(4.dp))
                .padding(bottom = 5.dp)
                .clickable(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(artistUrl))
                    context.startActivity(intent)
                }),
            failure = {
                Box {
                    Image(
                        painter = painterResource(R.drawable.chill_headphones_guy),
                        contentDescription = null,
                        modifier = Modifier
                            .size(154.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .padding(bottom = 5.dp)
                    )
                }
            })

        Text(
            text = artistName, color = Color.White, fontSize = 12.sp
        )
        Text(
            text = albumName, color = Color.White, fontSize = 12.sp
        )
    }
}