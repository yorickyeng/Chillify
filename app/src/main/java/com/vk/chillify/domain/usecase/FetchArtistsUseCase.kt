package com.vk.chillify.domain.usecase

import com.vk.chillify.domain.entity.Artist
import com.vk.chillify.domain.repository.SpotifyRepository
import javax.inject.Inject

class FetchArtistsUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(authToken: String): List<Artist> {
        return repository.fetchArtists(authToken)
    }
}