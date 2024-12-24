package com.vk.chillify.domain.usecase

import com.vk.chillify.domain.repository.SpotifyRepository
import javax.inject.Inject

class FetchAuthTokenUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(): String {
        return repository.fetchAuthToken()
    }
}