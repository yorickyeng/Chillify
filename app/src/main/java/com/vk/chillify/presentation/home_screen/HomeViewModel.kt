package com.vk.chillify.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.chillify.domain.entity.Artist
import com.vk.chillify.domain.usecase.FetchArtistUseCase
import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val fetchAuthTokenUseCase: FetchAuthTokenUseCase,
    private val fetchArtistUseCase: FetchArtistUseCase
) : ViewModel() {

    private var authToken = ""

    private val _artist = MutableStateFlow(Artist("Maybe you need VPN", ""))
    val artist: StateFlow<Artist> get() = _artist

    init {
        fetchAuthToken()
    }

    private fun fetchAuthToken() {
        viewModelScope.launch {
            authToken = fetchAuthTokenUseCase()
            fetchArtist()
        }
    }

    private fun fetchArtist() {
        viewModelScope.launch {
            if (authToken.isNotEmpty()) {
                _artist.value = fetchArtistUseCase(authToken)
            }
        }
    }

    fun playTrack(){

    }

}