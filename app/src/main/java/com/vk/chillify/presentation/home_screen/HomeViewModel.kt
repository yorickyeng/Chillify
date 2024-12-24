package com.vk.chillify.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.chillify.domain.entity.Album
import com.vk.chillify.domain.entity.Artist

import com.vk.chillify.domain.usecase.FetchAuthTokenUseCase
import com.vk.chillify.domain.usecase.FetchArtistsUseCase
import com.vk.chillify.domain.usecase.FetchPopularAlbumsUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val fetchAuthTokenUseCase: FetchAuthTokenUseCase,
    private val fetchArtistsUseCase: FetchArtistsUseCase,
    private val fetchPopularAlbumsUseCase: FetchPopularAlbumsUseCase,
) : ViewModel() {

    private var authToken = ""

    private val _artists = MutableStateFlow<List<Artist>>(emptyList())
    val artists: StateFlow<List<Artist>> get() = _artists

    private val _popularAlbums = MutableStateFlow<List<Album>>(emptyList())
    val popularAlbums: StateFlow<List<Album>> get() = _popularAlbums

    init {
        fetchAuthToken()
    }

    private fun fetchAuthToken() {
        viewModelScope.launch {
            authToken = fetchAuthTokenUseCase()
            fetchArtists()
            fetchPopularAlbums()
        }
    }

    private fun fetchArtists() {
        viewModelScope.launch {
            if (authToken.isNotEmpty()) {
                val fetchedArtists = fetchArtistsUseCase(authToken)
                _artists.value = fetchedArtists
            }
        }
    }

    private fun fetchPopularAlbums() {
        viewModelScope.launch {
            if (authToken.isNotEmpty()) {
                val fetchedPopularAlbums = fetchPopularAlbumsUseCase(authToken)
                _popularAlbums.value = fetchedPopularAlbums
            }
        }
    }

    fun playTrack(){

    }

}