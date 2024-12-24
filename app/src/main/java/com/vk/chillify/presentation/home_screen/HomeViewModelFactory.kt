package com.vk.chillify.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vk.chillify.domain.usecase.FetchArtistUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val fetchAuthTokenUseCase: FetchAuthTokenUseCase,
    private val fetchArtistUseCase: FetchArtistUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return HomeViewModel(
                fetchAuthTokenUseCase, fetchArtistUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}