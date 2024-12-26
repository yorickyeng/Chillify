package com.vk.chillify.data.repository

import com.vk.chillify.data.datasource.remote.AccountsApiService
import com.vk.chillify.data.datasource.remote.SpotifyApiService
import com.vk.chillify.domain.entity.Album
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

    override suspend fun fetchArtists(authToken: String): List<Artist> {
        val randomArtistIds = artistIds.take(artistIds.size).shuffled().joinToString(",")
        println(authToken)
        return try {
            val response = spotifyApiService.getArtists("Bearer $authToken", randomArtistIds)
            response.artists.map { artistResponse ->
                Artist(
                    artistName = artistResponse.name,
                    artistImageUrl = artistResponse.images?.get(0)?.url.orEmpty(),
                    artistUrl = artistResponse.externalUrls.spotify
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    // not using now
    override suspend fun fetchPopularArtists(authToken: String): List<Artist> {
        return try {
            val response = spotifyApiService.getPopularAlbums("Bearer $authToken")
            println(authToken)
            println(response)
            response.albums.items.flatMap { albumItem ->
                albumItem.artists.map {
                    Artist(
                        artistName = albumItem.albumName,
                        artistImageUrl = albumItem.images.firstOrNull()?.url.orEmpty(),
                        artistUrl = albumItem.albumName, // заглушка
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun fetchPopularAlbum(authToken: String): List<Album> {
        return try {
            val response = spotifyApiService.getPopularAlbums("Bearer $authToken")
            response.albums.items.map { albumItem ->
                Album(
                    albumName = albumItem.albumName,
                    albumImageUrl = albumItem.images.firstOrNull()?.url.orEmpty(),
                    albumUrl = albumItem.externalUrls.spotify,
                    artist = albumItem.artists.firstOrNull()?.let { artistResponse ->
                        Artist(
                            artistName = artistResponse.name,
                            artistImageUrl = artistResponse.images?.get(0)?.url.orEmpty(),
                            artistUrl = artistResponse.externalUrls.spotify
                        )
                    } ?: Artist(artistName = "Unknown Artist", artistImageUrl = "", artistUrl = "")
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
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
    "2GUwb2rxMKePzxDi94EEoZ",
    "3IpQziA6YwD53PQ5xbwgLF",
    "3l0CmX0FuQjFxr8SK7Vqag",
    "3yY2gUcIsjMr8hjo51PoJ8",
)