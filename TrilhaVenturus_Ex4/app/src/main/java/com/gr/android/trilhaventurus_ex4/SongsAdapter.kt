package com.gr.android.trilhaventurus_ex4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gr.android.trilhaventurus_ex4.databinding.MusicItemBinding

class SongsAdapter (
    private val list: List<Song>,
    private val onItemClickListener: ItemClickListener
        ) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent,false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val product = list[position]
        holder.bind(product, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size

}

class SongViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(song: Song, onItemClickListener: ItemClickListener) {
        view.apply {
            setOnClickListener { onItemClickListener.onClick(song) }
            findViewById<TextView>(R.id.txt_song).text = song.song
            findViewById<TextView>(R.id.txt_duration).text = song.duration
        }
    }
}

fun interface ItemClickListener {
    fun onClick(song: Song)
}