package com.cvillaseca.spotifykt.network.auth

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface OAuthService {

    @Headers("Content-Type: application/x-www-form-urlencoded")

    @POST("token")
    @FormUrlEncoded
    fun getToken(
        @Header("Authorization") auth: String,
        @Field("grant_type") grandType: String
    ): Single<Token>

    @POST("token")
    @FormUrlEncoded
    fun refreshToken(
        @Header("Authorization") auth: String,
        @Field("grant_type") grandType: String,
        @Field("refresh_token") refreshToken: String
    ): Single<Token>
}
