package com.vk.chillify.domain.usecase

import com.vk.chillify.domain.entity.Album
import com.vk.chillify.domain.repository.SpotifyRepository
import javax.inject.Inject

class FetchPopularAlbumsUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(authToken: String): List<Album> {
        return repository.fetchPopularAlbum(authToken)
    }
}