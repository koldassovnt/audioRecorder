package com.example.audiorecorder.util

import com.example.audiorecorder.player.RecordingRepository
import com.example.audiorecorder.player.RecordingViewModelProvider
import com.example.audiorecorder.recorder.RecorderRepository
import com.example.audiorecorder.recorder.RecorderViewModelProvider

object InjectorUtils {
    fun provideRecorderViewModelFactory(): RecorderViewModelProvider {
        val recorderRepository = RecorderRepository.getInstance()
        return RecorderViewModelProvider(recorderRepository)
    }

    fun provideRecordingViewModelFactory(): RecordingViewModelProvider {
        val recordingRepository = RecordingRepository.getInstance()
        return RecordingViewModelProvider(recordingRepository)
    }
}