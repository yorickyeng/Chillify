package com.vk.chillify.presentation.viewModels

import android.app.Application
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import com.vk.chillify.data.repository.AudioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MusicViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application
    private val audio = AudioRepository.audio
    private val url = "https://getfile.dokpub.com/yandex/get/https://disk.yandex.ru/d/G9hq4_0IiACVgg"


    init {
        audio.shuffle()
    }

    private var _currentTrack = MutableStateFlow(0)
    private var _songName =
        MutableStateFlow(context.resources.getResourceName(audio[_currentTrack.value]))
    val songName: StateFlow<String> = _songName

    private val mMediaPlayer = MediaPlayer().apply {
//        setDataSource(context.resources.openRawResourceFd(audio[_currentTrack.value])) // Устанавливаем URL в качестве источника
        setDataSource(url)
        prepareAsync() // Асинхронная подготовка
        setOnPreparedListener {

            pause() // Начинаем воспроизведение, когда файл готов
        }
    }



    private var _isPlaying = MutableStateFlow(mMediaPlayer.isPlaying)
    val isPlaying: StateFlow<Boolean> = _isPlaying


    fun nextTrack() {
        _currentTrack.value += 1
        if (_currentTrack.value == audio.size) _currentTrack.value = 0
        play()
    }

    fun previousTrack() {
        _currentTrack.value -= 1
        if (_currentTrack.value == -1) _currentTrack.value = audio.size - 1
        play()

    }

    private fun play() {
        mMediaPlayer.apply {
            stop()
            reset()
//            setDataSource(context.resources.openRawResourceFd(audio[_currentTrack.value]))
            setDataSource(url)
            prepareAsync()
            setOnPreparedListener {
                playPause() // Начинаем воспроизведение, когда файл готов
            }
        }
        _songName.value = context.resources.getResourceName(audio[_currentTrack.value])

    }


    fun playPause() {
        if (mMediaPlayer.isPlaying) {
            mMediaPlayer.pause()
            _isPlaying.value = false
        } else {
            mMediaPlayer.start()
            _isPlaying.value = true
        }
    }

    fun shareLink(link: String, context: Context) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, link)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Share Link")
        context.startActivity(shareIntent)
    }

    override fun onCleared() {
        super.onCleared()
        mMediaPlayer.release()
    }

}