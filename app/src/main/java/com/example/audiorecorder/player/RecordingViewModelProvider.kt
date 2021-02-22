package com.example.audiorecorder.player

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class RecordingViewModelProvider(private val recordingRepository: RecordingRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecordingViewModel(recordingRepository) as T
    }
}