package com.vk.chillify.domain.usecase

import com.vk.chillify.domain.entity.Artist
import com.vk.chillify.domain.repository.SpotifyRepository
import javax.inject.Inject

class FetchArtistUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(authToken: String): Artist {
        return repository.fetchArtist(authToken)
    }
}