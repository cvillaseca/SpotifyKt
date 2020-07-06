package com.cvillaseca.spotifykt.cache

import android.content.Context

import com.pacoworks.rxpaper2.RxPaperBook
import io.paperdb.Book
import io.paperdb.Paper
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io

/**
 * Paper is a fast NoSQL-like storage for Java/Kotlin objects on Android with automatic schema migration support.
 * See: https://github.com/pakoito/RxPaper2
 */

object CacheLibrary {
    fun init(context: Context) = RxPaperBook.init(context)
}

class Cache<T> {
    private val book: Book = Paper.book()

    fun load(key: String): T = book.read(key)

    fun save(key: String, anyObject: T): T =
        book.write(key, anyObject).run { anyObject }

    fun delete(key: String) = book.delete(key)
}

class ReactiveCache<T> {
    private val book: RxPaperBook = RxPaperBook.with(io())

    fun load(key: String): Single<T> = book.read(key)

    fun save(key: String, anyObject: T): Single<T> =
        book.write(key, anyObject).toSingleDefault(anyObject)

    fun delete(key: String): Completable = book.delete(key)
}
