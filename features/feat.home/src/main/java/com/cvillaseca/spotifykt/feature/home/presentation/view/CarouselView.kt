package com.cvillaseca.spotifykt.feature.home.presentation.view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CarouselView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : Carousel(context, attrs, defStyleAttr) {

    init {
        isNestedScrollingEnabled = false
    }

    private val defaultSnapHelperFactory: SnapHelperFactory = object : SnapHelperFactory() {
        override fun buildSnapHelper(context: Context?): SnapHelper = LinearSnapHelper()
    }

    override fun getSnapHelperFactory(): SnapHelperFactory? = null

    @JvmOverloads
    @CallbackProp
    fun setSnapHelperFactory(snapHelperFactory: SnapHelperFactory? = defaultSnapHelperFactory) {
        onFlingListener = null
        snapHelperFactory?.buildSnapHelper(context)?.attachToRecyclerView(this)
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        adapter?.registerAdapterDataObserver(
            object : AdapterDataObserver() {
                override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                    super.onItemRangeChanged(positionStart, itemCount)
                    scrollToFirst()
                }

                override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
                    super.onItemRangeChanged(positionStart, itemCount, payload)
                    scrollToFirst()
                }

                override fun onChanged() {
                    super.onChanged()
                    scrollToFirst()
                }

                override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                    super.onItemRangeRemoved(positionStart, itemCount)
                    scrollToFirst()
                }

                override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                    super.onItemRangeMoved(fromPosition, toPosition, itemCount)
                    scrollToFirst()
                }

                override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                    super.onItemRangeInserted(positionStart, itemCount)
                    scrollToFirst()
                }
            }
        )
        super.setAdapter(adapter)
    }

    private fun scrollToFirst() =
        (layoutManager as LinearLayoutManager).scrollToPositionWithOffset(0, 0)

    public override fun createLayoutManager(): RecyclerView.LayoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}
