package com.cvillaseca.spotifykt.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.cvillaseca.spotifykt.presentation.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
open class PrimaryTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        val styledAttrs = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PrimaryTextView,
            0,
            0
        )
        bindAttrs(styledAttrs)
        styledAttrs.recycle()
    }

    @Suppress("MagicNumber")
    private fun bindAttrs(styledAttrs: TypedArray) = setTextStyle(
        TextStyle.fromStyleableIndex(
            styledAttrs.getInt(R.styleable.PrimaryTextView_text_style, 4)
        )
    )

    @TextProp
    fun setBody(text: CharSequence) {
        this.text = text
    }

    @JvmOverloads
    @ModelProp
    fun setColor(@ColorRes color: Int = R.color.black) =
        setTextColor(ContextCompat.getColor(context, color))

    @ModelProp
    @JvmOverloads
    fun setTextStyle(style: TextStyle = TextStyle.BODY) = setTextAppearance(style.styleRes)

    @ModelProp
    @JvmOverloads
    fun setTextGravity(gravity: Int = Gravity.START) {
        gravity.takeIf { it > 0 }
            ?.let { setGravity(it) }
            ?: setGravity(Gravity.START)
    }

    @ModelProp(options = [ModelProp.Option.DoNotHash])
    fun setPadding(padding: Padding?) =
        padding?.let { padding ->
            setViewPadding(padding)
        }

    @CallbackProp
    fun setClickListener(listener: ((View) -> Unit)?) {
        isClickable = true
        setOnClickListener(listener)
    }

    @Suppress("MagicNumber")
    enum class TextStyle(val styleableIndex: Int, @StyleRes val styleRes: Int) {
        HEADER_L(0, R.style.PrimaryTextView_HeaderL),
        HEADER_M(1, R.style.PrimaryTextView_HeaderM),
        HEADER_S(2, R.style.PrimaryTextView_HeaderS),
        HEADER_XS(3, R.style.PrimaryTextView_HeaderXS),
        BODY(4, R.style.PrimaryTextView_Body),
        EYEBROW(5, R.style.PrimaryTextView_Eyebrow),
        CAPTION(6, R.style.PrimaryTextView_Caption),
        LINK(7, R.style.PrimaryTextView_Link);

        companion object {
            fun fromStyleableIndex(styleableIndex: Int): TextStyle =
                values().first { it.styleableIndex == styleableIndex }
        }
    }
}
