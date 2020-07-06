package com.cvillaseca.spotifykt.view

import android.content.Context
import android.view.View
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.cvillaseca.spotifykt.view.extensions.dip

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SpaceView(context: Context) : View(context) {

    @ModelProp(group = "height_space")
    fun setHeightDimenRes(heightDimenRes: Int) {
        val modifiedLayoutParams = layoutParams
        modifiedLayoutParams.height = context.resources.getDimensionPixelSize(heightDimenRes)
        layoutParams = modifiedLayoutParams
    }

    @ModelProp(group = "height_space")
    fun setHeightDimenDp(heightDimenDp: Int) {
        val modifiedLayoutParams = layoutParams
        modifiedLayoutParams.height = dip(heightDimenDp)
        layoutParams = modifiedLayoutParams
    }

    @ModelProp(group = "height_space")
    fun setHeightDimenPx(heightDimenPx: Int) {
        val modifiedLayoutParams = layoutParams
        modifiedLayoutParams.height = heightDimenPx
        layoutParams = modifiedLayoutParams
    }
}
