package com.vk.chillify.presentation.screens.search_screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vk.chillify.presentation.templates.Header

@Composable
fun SearchScreen(navController: NavController) {

    val searchQuery = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121111))
            .padding(horizontal = 10.dp)
            .verticalScroll(enabled = true, state = remember { ScrollState(0) })
    ) {
        Header(navController)
        Spacer(modifier = Modifier.height(20.dp))

        SearchBar(searchQuery.value) { query ->
            searchQuery.value = query
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Browse All",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        CategoryGrid()
    }
}

@Composable
fun SearchBar(searchQuery: String, onQueryChanged: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF1E1E1E))
            .padding(horizontal = 15.dp, vertical = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = searchQuery,
            onValueChange = onQueryChanged,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = { /* Perform search */ }),
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp
            ),
            modifier = Modifier.fillMaxWidth(),
            cursorBrush = SolidColor(Color.White),
            decorationBox = { innerTextField ->
                if (searchQuery.isEmpty()) {
                    Text(
                        text = "Search for artists, songs, or albums",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun CategoryGrid() {
    val categories = listOf(
        "Pop" to Color(0xFFe91e63),
        "Hip Hop" to Color(0xFF4caf50),
        "Rock" to Color(0xFF3f51b5),
        "Jazz" to Color(0xFFf57c00),
        "Electronic" to Color(0xFF9c27b0),
        "Country" to Color(0xFF2196f3),
        "Classical" to Color(0xFF795548),
        "Indie" to Color(0xFF009688),
        "Blues" to Color(0xFF673ab7),
        "Reggae" to Color(0xFFff9800)
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 6.dp)
    ) {
        categories.chunked(2).forEach { rowCategories ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                rowCategories.forEach { (title, color) ->
                    CategoryCard(
                        title = title,
                        backgroundColor = color,
                        modifier = Modifier.weight(1f)
                    ) {
                        // Handle click to navigate
                    }
                }

                // Добавляем пустую карточку для заполнения пространства, если количество категорий нечетное
                if (rowCategories.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun CategoryCard(title: String, backgroundColor: Color, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .aspectRatio(1.5f) // Сохраняем пропорции 3:2
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}