package com.gr.android.trilhaventurus_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gr.android.trilhaventurus_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val recyclerView : RecyclerView = binding.listRv

        val onClickListener = ItemClickListener {
            song ->
            Toast.makeText(this, "Song:  ${ song.song.toString() }", Toast.LENGTH_SHORT).show()
        }

        val adapter = SongsAdapter(SongsList().fetchSongs(), onClickListener)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }


}