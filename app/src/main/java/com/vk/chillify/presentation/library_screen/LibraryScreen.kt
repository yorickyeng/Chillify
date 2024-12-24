package com.vk.chillify.presentation.library_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import com.vk.chillify.presentation.templates.Header

//@Preview(showSystemUi = true)
@Composable
fun LibraryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121111)),
    ) {
        Header()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 6.dp)
        ) {
            for (i in 0..10){
                item{
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ){
                        Image(
                            painter = painterResource(R.drawable.chill_headphones_guy),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .padding(bottom = 5.dp)
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)){
                            Text(
                                text = "Cool playlist", color = Color.White, fontSize = 18.sp
                            )
                            Text(
                                text = "Cool author", color = Color.Gray, fontSize = 14.sp
                            )

                        }
                    }
                }
            }


        }


    }
}