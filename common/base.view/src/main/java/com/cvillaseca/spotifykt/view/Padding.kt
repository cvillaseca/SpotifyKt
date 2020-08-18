package com.cvillaseca.spotifykt.view

import android.view.View
import androidx.annotation.DimenRes

sealed class Padding {
    data class Multiple(
        @DimenRes val topResId: Int,
        @DimenRes val bottomResId: Int,
        @DimenRes val leftResId: Int,
        @DimenRes val rightResId: Int
    ) : Padding()

    data class HorVer(
        @DimenRes val horizontal: Int,
        @DimenRes val vertical: Int
    ) : Padding()

    data class Single(
        @DimenRes val value: Int
    ) : Padding()
}

fun View.setViewPadding(padding: Padding) =
    when (padding) {
        is Padding.Multiple ->
            setPadding(
                padding.leftResId.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.topResId.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.rightResId.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.bottomResId.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0
            )
        is Padding.HorVer ->
            setPadding(
                padding.horizontal.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.vertical.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.horizontal.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.vertical.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0
            )
        is Padding.Single ->
            setPadding(
                padding.value.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.value.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.value.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0,
                padding.value.takeIf { it > 0 }
                    ?.let { context.resources.getDimensionPixelSize(it) } ?: 0
            )
    }
