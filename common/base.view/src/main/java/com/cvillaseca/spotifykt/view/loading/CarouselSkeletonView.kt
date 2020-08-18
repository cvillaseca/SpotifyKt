package com.cvillaseca.spotifykt.view.loading

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.ModelView
import com.cvillaseca.spotifykt.presentation.R
import io.supercharge.shimmerlayout.ShimmerLayout

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CarouselSkeletonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ShimmerLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_item_carousel_skeleton, this)
        setShimmerColor(Color.WHITE)
        setShimmerAnimationDuration(ANIMATION_DURATION_MS)
    }

    @AfterPropsSet
    fun postBindSetup() {
        startShimmerAnimation()
    }

    companion object {
        const val ANIMATION_DURATION_MS = 1000
    }
}
