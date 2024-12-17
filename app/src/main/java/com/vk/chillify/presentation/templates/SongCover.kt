package com.vk.chillify.presentation.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.chillify.R

@Composable
fun SongCover() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.chill_headphones_guy),
            contentDescription = null,
            modifier = Modifier
                .size(154.dp)
                .clip(RoundedCornerShape(4.dp))
                .padding(bottom = 5.dp)
        )
        Text(
            text = "1 (Remastered)", color = Color.White, fontSize = 12.sp
        )
    }
}