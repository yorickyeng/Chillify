package com.vk.chillify.presentation.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vk.chillify.presentation.templates.Header
import com.vk.chillify.presentation.templates.HorizontalFramesRow
import com.vk.chillify.presentation.templates.SongCover
import com.vk.chillify.presentation.templates.SongsSection

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121111))
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {
            item { Header() }
            item { SongsSection("Search)))))") }
            repeat(10) {
                item { HorizontalFramesRow { SongCover() } }
            }
        }
    }
}