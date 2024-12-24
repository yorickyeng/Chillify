package com.vk.chillify.domain.repository

import com.vk.chillify.domain.entity.Artist

interface SpotifyRepository {
    suspend fun fetchAuthToken(): String
    suspend fun fetchArtist(authToken: String): Artist
}