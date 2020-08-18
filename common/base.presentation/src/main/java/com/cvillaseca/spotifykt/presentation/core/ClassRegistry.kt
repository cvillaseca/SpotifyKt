package com.cvillaseca.spotifykt.presentation.core

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.concurrent.ConcurrentHashMap

internal object ClassRegistry {
    private val CLASS_MAP = ConcurrentHashMap<String, Class<*>>()

    @Suppress("UNCHECKED_CAST")
    private fun <T> loadClass(className: String): Class<T> =
        CLASS_MAP.getOrPut(className) { Class.forName(className) } as Class<T>

    fun loadFragment(className: String, args: Bundle? = null): Fragment =
        loadClass<Fragment>(className).newInstance().apply { arguments = args }

    fun loadIntent(packageName: String, className: String): Intent =
        Intent(Intent.ACTION_VIEW).setClassName(packageName, className)
}
