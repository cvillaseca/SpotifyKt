package com.cvillaseca.spotifykt.network.auth

import com.cvillaseca.spotifykt.cache.Cache
import javax.inject.Inject

class OAuthAccessTokenLocalDataSource @Inject constructor() {

    private val tokenCache = Cache<Token>()

    val localToken: Token?
        get() = tokenCache.load(TOKEN_KEY)

    fun storeToken(token: Token) {
        tokenCache.save(TOKEN_KEY, token)
    }

    fun clearTokens() {
        tokenCache.delete(TOKEN_KEY)
    }

    companion object {
        private const val TOKEN_KEY = "token"
    }
}
