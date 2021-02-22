package com.example.audiorecorder.player

import android.arch.lifecycle.ViewModel

class RecordingViewModel(private val recordingRepository: RecordingRepository): ViewModel(){

    fun getRecordings() = recordingRepository.getRecordings()
}