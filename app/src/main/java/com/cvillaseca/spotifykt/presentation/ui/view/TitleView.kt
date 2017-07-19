package com.cvillaseca.spotifykt.presentation.ui.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.cvillaseca.spotifykt.R

class TitleView : LinearLayout {

    private var textView: TextView? = null


    constructor(context: Context) : super(context) {
        init(null, 0, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr, 0)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs, defStyleAttr, defStyleRes)
    }


    private fun init(attrs: AttributeSet?, defStyleAttr: Int, defStyleRe: Int) {
        val view = View.inflate(context, R.layout.view_title, this)

        textView = view.findViewById(R.id.title) as TextView

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.TitleView, defStyleAttr, defStyleRe)
            textView!!.text = a.getString(R.styleable.TitleView_title_view_text)
            textView!!.setTextColor(a.getColor(R.styleable.TitleView_title_view_text_color, ContextCompat.getColor(context, R.color.white)))

            val size = a.getDimensionPixelSize(R.styleable.TitleView_title_view_text_size, 0).toFloat()
            if (size > 0) {
                textView!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
            }


            a.recycle()
        }
    }

    fun setTitle(title: String) {
        textView!!.text = title
    }

}
