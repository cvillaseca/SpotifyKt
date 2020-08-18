package com.cvillaseca.spotifykt.login.data

import com.cvillaseca.spotifykt.cache.Cache
import com.cvillaseca.spotifykt.network.auth.Token
import javax.inject.Inject

class LoginLocalDataSource @Inject constructor() {

    private val tokenCache = Cache<Token>()

    fun storeToken(token: Token) {
        tokenCache.save(TOKEN_KEY, token)
    }

    companion object {
        private const val TOKEN_KEY = "token"
    }
}
