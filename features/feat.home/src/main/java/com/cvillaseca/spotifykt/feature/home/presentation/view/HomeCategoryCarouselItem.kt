package com.cvillaseca.spotifykt.feature.home.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.cvillaseca.spotifykt.feature.home.R
import com.cvillaseca.spotifykt.view.extensions.loadImage
import kotlinx.android.synthetic.main.view_category_item.view.*

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT, saveViewState = true)
class HomeCategoryCarouselItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        radius = resources.getDimension(R.dimen.margin_small)
        View.inflate(context, R.layout.view_category_item, this)
    }

    @ModelProp
    fun setName(cityName: String) {
        name.text = cityName
    }

    @ModelProp
    fun setImage(url: String) =
        image.loadImage(url)

    @CallbackProp
    fun setClickListener(listener: View.OnClickListener?) {
        setOnClickListener(listener)
    }
}
