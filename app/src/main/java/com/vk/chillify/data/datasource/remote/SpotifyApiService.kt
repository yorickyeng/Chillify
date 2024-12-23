package com.vk.chillify.data.datasource.remote

import com.vk.chillify.data.model.ArtistResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SpotifyApiService {
    @GET("v1/artists/{id}")
    suspend fun getArtist(
        @Header("Authorization") authHeader: String,
        @Path("id") artistId: String
    ): ArtistResponse
}