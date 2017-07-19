package com.cvillaseca.spotifykt.presentation.ui.view.scrollview

import android.content.Context
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet

class NotifyingScrollView : NestedScrollView {

    interface OnScrollChangedListener {
        fun onScrollChanged(who: NestedScrollView, l: Int, t: Int, oldl: Int, oldt: Int)
    }

    private var mOnScrollChangedListener: OnScrollChangedListener? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener!!.onScrollChanged(this, l, t, oldl, oldt)
        }
    }

    fun setOnScrollChangedListener(listener: OnScrollChangedListener) {
        mOnScrollChangedListener = listener
    }

}
