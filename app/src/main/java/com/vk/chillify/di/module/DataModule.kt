package com.vk.chillify.di.module

import com.vk.chillify.data.datasource.remote.AccountsApiService
import com.vk.chillify.data.datasource.remote.SpotifyApiService
import com.vk.chillify.data.repository.SpotifyRepositoryImpl
import com.vk.chillify.domain.repository.SpotifyRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideSpotifyApiService(): SpotifyApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpotifyApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAccountsApiService(): AccountsApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_ACCOUNTS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AccountsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSpotifyRepository(
        spotifyApiService: SpotifyApiService,
        accountsApiService: AccountsApiService
    ): SpotifyRepository {
        return SpotifyRepositoryImpl(spotifyApiService, accountsApiService)
    }

    private companion object {
        private const val BASE_URL = "https://api.spotify.com/"
        private const val BASE_ACCOUNTS_URL = "https://accounts.spotify.com/"
    }
}