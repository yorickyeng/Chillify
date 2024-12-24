package com.vk.chillify.domain.repository

import com.vk.chillify.domain.entity.Album
import com.vk.chillify.domain.entity.Artist

interface SpotifyRepository {
    suspend fun fetchAuthToken(): String
    suspend fun fetchArtists(authToken: String): List<Artist>
    suspend fun fetchPopularArtists(authToken: String): List<Artist>
    suspend fun fetchPopularAlbum(authToken: String): List<Album>
}