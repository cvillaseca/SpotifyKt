package com.cvillaseca.spotifykt.network.auth

import javax.inject.Inject

class OAuthAccessTokenRemoteDataSource @Inject constructor(
    private val oauthService: OAuthService
) {
    suspend fun getToken(authHeader: String) =
        oauthService.getToken(authHeader, "client_credentials")

    suspend fun refreshToken(authHeader: String, token: String) =
        oauthService.refreshToken(authHeader, "refresh_token", token)
}
