package com.cvillaseca.spotifykt.presentation.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel
import com.cvillaseca.spotifykt.presentation.ui.viewholder.TrackViewHolder
import java.util.ArrayList

class TracksAdapter(private val trackListener: TrackViewHolder.TrackListener) : RecyclerView.Adapter<TrackViewHolder>() {

    private val items = ArrayList<TrackModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_track, parent, false)
        return TrackViewHolder(trackListener, view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.render(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(trackModels: List<TrackModel>) {
        items.clear()
        items.addAll(trackModels)
        notifyDataSetChanged()
    }

    fun addItems(trackModels: List<TrackModel>) {
        val currentSize = items.size
        items.addAll(trackModels)
        notifyItemRangeChanged(currentSize, trackModels.size)
    }
}
