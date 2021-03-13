package com.cvillaseca.spotifykt.network.auth.interceptor

import com.cvillaseca.spotifykt.network.NetworkConstants
import com.cvillaseca.spotifykt.network.auth.OAuthAccessTokenRepository
import com.cvillaseca.spotifykt.network.auth.Token
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val oAuthAccessTokenRepository: OAuthAccessTokenRepository
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val token: Token? = oAuthAccessTokenRepository.localToken
        Timber.tag("AuthInterceptor").d("Token $token")
        if (token != null) {
            request = chain.request().newBuilder().addHeader(
                NetworkConstants.AUTHORIZATION,
                NetworkConstants.BEARER + " " + token.accessToken
            ).build()
        }

        return chain.proceed(request)
    }
}
