package com.cvillaseca.spotifykt.navigation

private inline fun <reified T : Any> Any.cast() = this as T

internal fun <T> loadClass(className: String): Class<out T> =
    Class.forName(className).cast()
