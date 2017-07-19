package com.cvillaseca.spotifykt.presentation.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.ui.viewholder.ArtistViewHolder
import java.util.ArrayList

class ArtistsAdapter(private val artistListener: ArtistViewHolder.ArtistListener) : RecyclerView.Adapter<ArtistViewHolder>() {

    private val items = ArrayList<ArtistModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_artist, parent, false)
        return ArtistViewHolder(artistListener, view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.render(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(artists: List<ArtistModel>) {
        items.clear()
        items.addAll(artists)
        notifyDataSetChanged()
    }

    fun addItems(artists: List<ArtistModel>) {
        val currentSize = items.size
        items.addAll(artists)
        notifyItemRangeChanged(currentSize, artists.size)
    }
}
