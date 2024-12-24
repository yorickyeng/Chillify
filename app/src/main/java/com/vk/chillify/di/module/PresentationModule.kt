package com.vk.chillify.di.module

import com.vk.chillify.domain.usecase.FetchArtistUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import com.vk.chillify.presentation.home_screen.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

    @Provides
    @Singleton
    fun provideHomeViewModelFactory(
        fetchAuthTokenUseCase: FetchAuthTokenUseCase,
        fetchArtistUseCase: FetchArtistUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            fetchAuthTokenUseCase,
            fetchArtistUseCase
        )
    }
}