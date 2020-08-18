package com.cvillaseca.spotifykt.login.data

import com.cvillaseca.spotifykt.network.auth.Token
import com.cvillaseca.spotifykt.network.response.UserResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {

    @Headers("Content-Type: application/x-www-form-urlencoded")

    @POST("oauth/token")
    @FormUrlEncoded
    fun login(
        @Header("Authorization") auth: String,
        @Field("grant_type") grandType: String,
        @Field("username") user: String,
        @Field("password") password: String
    ): Single<Token>

    @GET("user/{id}")
    fun userData(@Path("id") userId: String): Single<UserResponse>
}
