package com.vk.chillify.presentation.templates

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import com.vk.chillify.R

@Preview(showSystemUi = true)
@Composable
fun SongCover(artistName: String, url: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        GlideImage(
            imageModel = { url },
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
                .padding(bottom = 5.dp),
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
    }
}