package com.vk.chillify.di.module

import com.vk.chillify.domain.repository.SpotifyRepository
import com.vk.chillify.domain.usecase.FetchArtistUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun fetchArtistUseCase(repository: SpotifyRepository): FetchArtistUseCase {
        return FetchArtistUseCase(repository)
    }

    @Provides
    fun fetchAuthTokenUseCase(repository: SpotifyRepository): FetchAuthTokenUseCase {
        return FetchAuthTokenUseCase(repository)
    }
}