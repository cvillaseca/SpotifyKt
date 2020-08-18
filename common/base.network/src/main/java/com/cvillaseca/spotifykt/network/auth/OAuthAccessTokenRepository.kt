package com.cvillaseca.spotifykt.network.auth

import javax.inject.Inject

class OAuthAccessTokenRepository @Inject constructor(
    private val localDataSource: OAuthAccessTokenLocalDataSource,
    private val remoteDatasource: OAuthAccessTokenRemoteDataSource
) {

    val localToken: Token?
        get() = localDataSource.localToken

    fun clearTokens() {
        localDataSource.clearTokens()
    }

    fun storeToken(token: Token) {
        localDataSource.storeToken(token)
    }

    fun getToken(authHeader: String) =
        localToken?.refreshToken?.let {
            remoteDatasource.refreshToken(authHeader, it)
        } ?: remoteDatasource.getToken(authHeader)
}
