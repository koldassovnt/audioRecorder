package com.example.audiorecorder.item

import android.content.Context
import com.example.audiorecorder.R
import com.example.audiorecorder.player.RecordingRepository
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.recording_layout.view.*

class Recording(private val title: String, private val context: Context): Item(){

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.recording_title_textview.text = title
        viewHolder.itemView.recording_image.setOnClickListener {
            RecordingRepository.playRecording(context, title )
        }
    }

    override fun getLayout(): Int {
        return R.layout.recording_layout
    }

}