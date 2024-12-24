package com.vk.chillify.presentation.viewModels

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import com.vk.chillify.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MusicViewModel(application: Application) : AndroidViewModel(application) {
    private var mMediaPlayer : MediaPlayer = MediaPlayer.create(application, R.raw.govnovoz)

    private var _isPlaying = MutableStateFlow(mMediaPlayer.isPlaying)
    val isPlaying : StateFlow<Boolean> = _isPlaying

    fun playPause(){
        if (mMediaPlayer.isPlaying){
            mMediaPlayer.pause()
            _isPlaying.value = false
        }else{
            mMediaPlayer.start()
            _isPlaying.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        mMediaPlayer.release()
    }

}