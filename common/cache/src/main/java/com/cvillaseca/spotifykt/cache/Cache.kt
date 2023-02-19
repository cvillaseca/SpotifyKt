package com.cvillaseca.spotifykt.cache

import android.content.Context
import io.paperdb.Book
import io.paperdb.Paper

/**
 * Paper is a fast NoSQL-like storage for Java/Kotlin objects on Android with automatic schema migration support.
 * See: https://github.com/pakoito/RxPaper2
 */

object CacheLibrary {
    fun init(context: Context) = Paper.init(context)
}

class Cache<T> {
    private val book: Book = Paper.book()

    fun load(key: String): T? = if (book.contains(key)) book.read(key) else null

    fun save(key: String, anyObject: T): T =
        book.write(key, anyObject).run { anyObject }

    fun delete(key: String) = book.delete(key)
}
