package com.vk.chillify.presentation.screens.settings_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121111))
    ) {
        Text(
            text = "Available soon :)",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}