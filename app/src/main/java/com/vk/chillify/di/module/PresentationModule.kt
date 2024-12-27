package com.vk.chillify.di.module

import com.vk.chillify.domain.usecase.FetchArtistsUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import com.vk.chillify.domain.usecase.FetchPopularAlbumsUseCase
import com.vk.chillify.presentation.screens.home_screen.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

    @Provides
    @Singleton
    fun provideHomeViewModelFactory(
        fetchAuthTokenUseCase: FetchAuthTokenUseCase,
        fetchArtistsUseCase: FetchArtistsUseCase,
        fetchPopularAlbumsUseCase: FetchPopularAlbumsUseCase,
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            fetchAuthTokenUseCase,
            fetchArtistsUseCase,
            fetchPopularAlbumsUseCase,
        )
    }
}