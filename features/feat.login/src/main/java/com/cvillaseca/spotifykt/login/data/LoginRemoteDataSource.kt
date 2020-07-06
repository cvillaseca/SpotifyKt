package com.cvillaseca.spotifykt.login.data

import android.util.Base64
import com.cvillaseca.spotifykt.network.NetworkConstants
import com.cvillaseca.spotifykt.network.auth.Token
import io.reactivex.Single
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(
    private val loginService: LoginService
) {

    fun login(username: String, password: String): Single<Token> {
        val clientId = NetworkConstants.API_CLIENT
        val secret = NetworkConstants.API_SECRET
        val base64auth = Base64.encodeToString("$clientId:$secret".toByteArray(), Base64.NO_WRAP)
        val authStr = NetworkConstants.BASIC + " $base64auth"
        return loginService.login(authStr, "password", username, password)
    }
}
