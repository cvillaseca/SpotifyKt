package com.cvillaseca.spotifykt.app.base.presentation.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife

abstract class BaseViewHolder<MODEL>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        ButterKnife.bind(this, itemView)
    }

    abstract fun render(model: MODEL, position: Int)
}