package com.vk.chillify.presentation

object StringFormatter {
    fun formatString(songName: String): String {
        val songNameFormatted = songName.drop(20)
        return songNameFormatted.replace("_", " ").replaceFirstChar { it.uppercaseChar() }
    }
}