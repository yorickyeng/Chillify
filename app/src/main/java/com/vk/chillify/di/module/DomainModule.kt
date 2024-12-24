package com.vk.chillify.di.module

import com.vk.chillify.domain.repository.SpotifyRepository
import com.vk.chillify.domain.usecase.FetchArtistsUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import com.vk.chillify.domain.usecase.FetchPopularAlbumsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun fetchArtistsUseCase(repository: SpotifyRepository): FetchArtistsUseCase {
        return FetchArtistsUseCase(repository)
    }

    @Provides
    fun fetchPopularArtistsUseCase(repository: SpotifyRepository): FetchPopularAlbumsUseCase {
        return FetchPopularAlbumsUseCase(repository)
    }

    @Provides
    fun fetchAuthTokenUseCase(repository: SpotifyRepository): FetchAuthTokenUseCase {
        return FetchAuthTokenUseCase(repository)
    }
}