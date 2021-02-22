package com.example.audiorecorder.recorder

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class RecorderViewModelProvider(private val recorderRepository: RecorderRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecorderViewModel(recorderRepository) as T
    }
}