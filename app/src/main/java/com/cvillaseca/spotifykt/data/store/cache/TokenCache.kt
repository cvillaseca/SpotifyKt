package com.cvillaseca.spotifykt.data.store.cache

import com.cvillaseca.spotifykt.data.entity.Token


interface TokenCache {
    fun getToken(): Token?
    fun saveToken(token: Token)
}