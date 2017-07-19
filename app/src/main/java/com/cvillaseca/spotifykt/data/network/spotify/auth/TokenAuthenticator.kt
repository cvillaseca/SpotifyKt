package com.cvillaseca.spotifykt.data.network.spotify.auth

import android.util.Base64
import com.cvillaseca.spotifykt.app.Constants
import com.cvillaseca.spotifykt.data.entity.Token
import com.cvillaseca.spotifykt.data.network.spotify.Constants.AUTHORIZATION
import com.cvillaseca.spotifykt.data.network.spotify.SpotifyApi
import com.cvillaseca.spotifykt.data.store.cache.RealmTokenCache
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator: Authenticator {

    var spotifyApi: SpotifyApi? = null
        set

    var tokenCache: RealmTokenCache? = null
        set

    override fun authenticate(route: Route?, response: Response?): Request {

        val clientId = Constants.API_CLIENT
        val secret = Constants.API_SECRET
        val base64auth = Base64.encodeToString("$clientId:$secret".toByteArray(), Base64.NO_WRAP)
        val authStr = "Basic $base64auth"

        var tokenStr:String? = null

        val responseToken = spotifyApi?.token(authStr,"client_credentials")?.execute()
        if (responseToken?.isSuccessful!!) {
            tokenStr = responseToken.body().accessToken!!
            tokenCache?.saveToken(responseToken.body())
        }

        return response?.request()?.newBuilder()!!
                .header(AUTHORIZATION, "Bearer " + tokenStr)
                .build()
    }


}