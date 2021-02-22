package com.example.audiorecorder.player

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.audiorecorder.R
import com.example.audiorecorder.item.Recording
import com.example.audiorecorder.util.InjectorUtils
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_recordings.*

class RecordingsActivity : AppCompatActivity() {

    private var viewModel: RecordingViewModel? = null
    private lateinit var groupAdapter: GroupAdapter<ViewHolder>
    private var data: ArrayList<String>? = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordings)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        groupAdapter = GroupAdapter<ViewHolder>()

        initUI()
    }

    override fun onStart() {
        super.onStart()

        recordings_recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
    }

    private fun initUI() {
        //Get the viewmodel factory
        val factory = InjectorUtils.provideRecordingViewModelFactory()

        //Getting the viewmodel
        viewModel = ViewModelProviders.of(this, factory).get(RecordingViewModel::class.java)

        updateAdapter()
    }

    private fun updateAdapter() {
        data = viewModel?.getRecordings()
        println("Updating Adapter")
        groupAdapter.clear()

        if(data != null) {
            data!!.forEach {
                println("Data: $it")
                groupAdapter.add(Recording(it,this))
            }
        }
    }
}
