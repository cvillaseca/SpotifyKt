package com.cvillaseca.spotifykt.presentation.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.ui.viewholder.AlbumViewHolder
import java.util.ArrayList

class AlbumsAdapter(private val albumListener: AlbumViewHolder.AlbumListener) : RecyclerView.Adapter<AlbumViewHolder>() {

    private val items = ArrayList<AlbumModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_artist, parent, false)
        return AlbumViewHolder(albumListener, view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.render(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(albumDtos: List<AlbumModel>) {
        items.clear()
        items.addAll(albumDtos)
        notifyDataSetChanged()
    }
}
