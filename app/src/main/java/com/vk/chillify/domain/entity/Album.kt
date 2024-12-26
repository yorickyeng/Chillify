package com.vk.chillify.domain.entity

data class Album(
    var albumName: String,
    var albumImageUrl: String,
    var albumUrl: String,
    var artist: Artist
)