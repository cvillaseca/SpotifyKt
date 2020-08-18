package com.cvillaseca.spotifykt.network.auth

import android.util.Base64
import com.cvillaseca.spotifykt.network.NetworkConstants
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class NetworkAuthenticator @Inject constructor(
    private val oAuthAccessTokenRepository: OAuthAccessTokenRepository
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val clientId = NetworkConstants.API_CLIENT
        val secret = NetworkConstants.API_SECRET
        val base64auth = Base64.encodeToString("$clientId:$secret".toByteArray(), Base64.NO_WRAP)
        val authStr = NetworkConstants.BASIC + " $base64auth"

        var tokenStr: String? = null

        val responseToken = oAuthAccessTokenRepository.getToken(authStr).blockingGet()
        if (responseToken != null) {
            tokenStr = responseToken.accessToken
            oAuthAccessTokenRepository.storeToken(responseToken)
        }

        return response.request.newBuilder()
            .header(NetworkConstants.AUTHORIZATION, NetworkConstants.BEARER + " " + tokenStr)
            .build()
    }
}
