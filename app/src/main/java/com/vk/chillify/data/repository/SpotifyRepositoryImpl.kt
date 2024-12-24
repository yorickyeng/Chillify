package com.vk.chillify.data.repository

import com.vk.chillify.data.datasource.remote.AccountsApiService
import com.vk.chillify.data.datasource.remote.SpotifyApiService
import com.vk.chillify.domain.entity.Artist
import com.vk.chillify.domain.repository.SpotifyRepository
import javax.inject.Inject

private const val clientId = "16026256c1fd4d93bfd9e73329ac5ff3"
private const val clientSecret = "4d8b3ac1eb1e4b8ba3ea2fab50590788"

class SpotifyRepositoryImpl @Inject constructor(
    private val spotifyApiService: SpotifyApiService,
    private val accountsApiService: AccountsApiService
) : SpotifyRepository {

    override suspend fun fetchAuthToken(): String {
        return try {
            val response = accountsApiService.getAccessToken(
                clientId = clientId, clientSecret = clientSecret
            )
            response.accessToken
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    override suspend fun fetchArtist(authToken: String): Artist {

        val randomArtistId = artistIds.random()

        return try {
            val response = spotifyApiService.getArtist("Bearer $authToken", randomArtistId)
            Artist(
                artistName = response.name, artistImageUrl = response.images?.get(0)?.url.orEmpty()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Artist(artistName = "Unknown Artist", artistImageUrl = "")
        }
    }
}

val artistIds = listOf(
    "6AyATGg7mDgBlZ4N5uNog0",
    "1GLtl8uqKmnyCWxHmw9tL4",
    "67fVkdcxRvcnMXPmuqXbZg",
    "2CIMQHirSU0MQqyYHq0eOx",
    "57dN52uHvrHOxijzpIgu3E",
    "1vCWHaC5f2uS3yhpwWbIA6",
)