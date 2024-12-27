package com.vk.chillify.presentation.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import com.vk.chillify.R
import com.vk.chillify.presentation.templates.navigation.Routes

@Composable
fun SongCover(
    navController: NavController,
    artistName: String,
    imageUrl: String,
    albumName: String = "",
    albumOrArtistUrl: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            imageModel = { imageUrl },
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
                .aspectRatio(1f)
                .clip(RoundedCornerShape(4.dp))
                .padding(bottom = 5.dp)
                .clickable(onClick = {
                    navController.navigate(
                        Routes.Information.createRoute(
                            imageUrl = imageUrl,
                            artistName = artistName,
                            albumName = albumName,
                            albumOrArtistUrl = albumOrArtistUrl
                        )
                    )
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