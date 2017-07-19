package com.cvillaseca.spotifykt.presentation.ui.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.ui.viewholder.BaseViewHolder
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel
import com.squareup.picasso.Picasso

class TrackViewHolder(private val trackListener: TrackViewHolder.TrackListener?, itemView: View) : BaseViewHolder<TrackModel>(itemView) {

    interface TrackListener {
        fun onClick(trackModel: TrackModel)
    }

    @BindView(R.id.picture)
    lateinit var picture: ImageView

    @BindView(R.id.name)
    lateinit var nameTv: TextView

    @BindView(R.id.album_name)
    lateinit var albumName: TextView

    private val context: Context = itemView.context

    override fun render(track: TrackModel, position: Int) {
        itemView.setOnClickListener({ view -> trackListener?.onClick(track) })

        if (track.album != null && track.album?.images != null && track.album?.images!!.isNotEmpty()) {
            Picasso.with(context).load(track.album!!.images!!.first().url).into(picture)
        } else {
            picture.visibility = View.GONE
        }

        nameTv.text = track.name

        if (track.album != null) {
            albumName.text = track.album!!.name
        } else {
            albumName.visibility = View.GONE
        }
    }
}