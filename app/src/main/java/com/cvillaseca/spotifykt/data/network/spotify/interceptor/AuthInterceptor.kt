package com.cvillaseca.spotifykt.data.network.spotify.interceptor

import com.cvillaseca.spotifykt.data.entity.Token
import com.cvillaseca.spotifykt.data.network.spotify.Constants.AUTHORIZATION
import com.cvillaseca.spotifykt.data.store.cache.RealmTokenCache
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

    var  tokenCache: RealmTokenCache? = null
        set

    override fun intercept(chain: Interceptor.Chain?): Response {

        var request = chain?.request()

        var token: Token? = tokenCache?.getToken()
        if (token != null) {
            request = chain?.request()?.newBuilder()?.addHeader(AUTHORIZATION, "Bearer " + token.accessToken)?.build()
        }

        return chain!!.proceed(request)
    }
}