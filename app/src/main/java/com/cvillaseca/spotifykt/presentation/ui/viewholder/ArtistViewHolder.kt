package com.cvillaseca.spotifykt.presentation.ui.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.ui.viewholder.BaseViewHolder
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.squareup.picasso.Picasso

class ArtistViewHolder(private val artistListener: ArtistViewHolder.ArtistListener?, itemView: View) : BaseViewHolder<ArtistModel>(itemView) {

    interface ArtistListener {
        fun onClick(view: View, artistModel: ArtistModel)
    }

    @BindView(R.id.picture)
    lateinit var picture: ImageView

    @BindView(R.id.name)
    lateinit var nameTv: TextView

    private val context: Context = itemView.context

    override fun render(model: ArtistModel, position: Int) {
        itemView.setOnClickListener({ artistListener?.onClick(picture, model) })

        if (model.thumbnail != null) {
            Picasso.with(context).load(model.thumbnail!!.url).into(picture)
        }

        nameTv.text = model.name
    }

}