package com.vk.chillify.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vk.chillify.domain.usecase.FetchArtistsUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import com.vk.chillify.domain.usecase.FetchPopularAlbumsUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val fetchAuthTokenUseCase: FetchAuthTokenUseCase,
    private val fetchArtistsUseCase: FetchArtistsUseCase,
    private val fetchPopularAlbumsUseCase: FetchPopularAlbumsUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return HomeViewModel(
                fetchAuthTokenUseCase, fetchArtistsUseCase, fetchPopularAlbumsUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}