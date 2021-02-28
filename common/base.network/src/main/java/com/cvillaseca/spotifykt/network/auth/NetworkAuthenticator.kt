package com.cvillaseca.spotifykt.network.auth

import android.util.Base64
import com.cvillaseca.spotifykt.network.BuildConfig
import com.cvillaseca.spotifykt.network.NetworkConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NetworkAuthenticator @Inject constructor(
    private val oAuthAccessTokenRepository: OAuthAccessTokenRepository
) : Authenticator, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Default

    override fun authenticate(route: Route?, response: Response): Request? {
        val clientId = BuildConfig.SPOTIFY_CLIENT
        val secret = BuildConfig.SPOTIFY_SECRET
        val base64auth = Base64.encodeToString("$clientId:$secret".toByteArray(), Base64.NO_WRAP)
        val authStr = NetworkConstants.BASIC + " $base64auth"

        var tokenStr: String? = null

        launch {
            val responseToken = oAuthAccessTokenRepository.getToken(authStr)
            if (responseToken != null) {
                tokenStr = responseToken.accessToken
                oAuthAccessTokenRepository.storeToken(responseToken)
            }
        }

        return response.request.newBuilder()
            .header(NetworkConstants.AUTHORIZATION, NetworkConstants.BEARER + " " + tokenStr)
            .build()
    }
}
