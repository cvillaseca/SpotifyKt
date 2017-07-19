package com.cvillaseca.spotifykt.presentation.ui.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.ui.viewholder.BaseViewHolder
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.squareup.picasso.Picasso

class AlbumViewHolder(private val albumListener: AlbumViewHolder.AlbumListener?, itemView: View) : BaseViewHolder<AlbumModel>(itemView) {

    interface AlbumListener {
        fun onClick(album: AlbumModel)
    }

    @BindView(R.id.picture)
    lateinit var picture: ImageView

    @BindView(R.id.name)
    lateinit var nameTv: TextView

    private val context: Context = itemView.context

    override fun render(model: AlbumModel, position: Int) {
        itemView.setOnClickListener({ albumListener?.onClick(model) })

        if (model.images != null && model.images!!.isNotEmpty()) {

            Picasso.with(context).load(model.images!!.first().url).into(picture)
        }

        nameTv.text = model.name
    }
}
