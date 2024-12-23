package com.vk.chillify.data.datasource.remote

import com.vk.chillify.data.model.ArtistResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface SpotifyApiService {
    @GET("v1/artists/3m6alJyeKYSCZ8078ttfaH")
    suspend fun getArtist(
        @Header("Authorization") authHeader: String
    ): ArtistResponse
}