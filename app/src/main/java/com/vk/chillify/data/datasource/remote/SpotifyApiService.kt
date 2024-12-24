package com.vk.chillify.data.datasource.remote

import com.vk.chillify.data.model.ArtistsResponse
import com.vk.chillify.data.model.PopularAlbumsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SpotifyApiService {
    @GET("v1/artists")
    suspend fun getArtists(
        @Header("Authorization") authHeader: String,
        @Query("ids") artistIds: String
    ): ArtistsResponse

    @GET("v1/browse/new-releases")
    suspend fun getPopularAlbums(
        @Header("Authorization") authHeader: String,
        @Query("country") country: String = "UK",
        @Query("limit") limit: Int = 50
    ): PopularAlbumsResponse
}