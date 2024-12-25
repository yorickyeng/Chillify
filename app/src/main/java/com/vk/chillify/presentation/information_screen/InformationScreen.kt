package com.vk.chillify.presentation.information_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skydoves.landscapist.glide.GlideImage
import com.vk.chillify.R
import com.vk.chillify.presentation.home_screen.HomeViewModel
import com.vk.chillify.presentation.home_screen.HomeViewModelFactory

@Composable
fun InformationScreen(
    homeViewModelFactory: HomeViewModelFactory
) {

    val viewModel: HomeViewModel = viewModel(
        factory = homeViewModelFactory
    )

    val context = LocalContext.current

    val artists by viewModel.artists.collectAsState()

    if (artists.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121111))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlideImage(imageModel = {
                artists[0].artistImageUrl
            },
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Color.White)
                    }
                },
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally),
                failure = {
                    Image(
                        painter = painterResource(R.drawable.chill_headphones_guy),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                })

            Text(
                text = artists[0].artistName,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Open in Spotify",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable(onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(artists[0].artistUrl))
                        context.startActivity(intent)
                    })
                    .padding(vertical = 8.dp),
                color = Color(0xFF1DB954), // Spotify green color
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

        }
    }
}