package com.vk.chillify.presentation.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vk.chillify.R
import com.vk.chillify.presentation.templates.navigation.Routes

@Composable
fun Header(navController: NavController) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .padding(top = 50.dp)
    ) {
        Text(
            text = "Chillify!",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Routes.Notifications.route) {
                        launchSingleTop = true
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.notifications),
                    contentDescription = "Notifications",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }

            IconButton(
                onClick = {
                    navController.navigate(Routes.Settings.route) {
                        launchSingleTop = true
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}