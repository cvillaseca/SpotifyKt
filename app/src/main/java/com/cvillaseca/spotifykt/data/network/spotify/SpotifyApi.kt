package com.cvillaseca.spotifykt.data.network.spotify

import com.cvillaseca.spotifykt.data.entity.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface SpotifyApi {

    @Headers("Content-Type: application/x-www-form-urlencoded")

    @POST("token")
    @FormUrlEncoded
    fun token(@Header("Authorization") auth:String,
              @Field("grant_type") grandType:String ): Call<Token>

    @POST("token")
    @FormUrlEncoded
    fun refreshToken(@Field("grant_type") grandType:String,
                     @Field("refresh_token") refreshToken:String ): Call<Token>

    @GET("search")
    fun search(@Query("query") query: String,
               @Query("offset") offset: Int?,
               @Query("limit") limit: Int?,
               @Query("type") type: String,
               @Query("market") market: String): Observable<SearchResponse>

    @GET("artists/{artistId}")
    fun artist(@Path("artistId") artistId: String): Observable<ArtistEntity>

    @GET("albums/{albumId}")
    fun album(@Path("albumId") albumId: String): Observable<AlbumEntity>

    @GET("artists/{artistId}/albums")
    fun albums(@Path("artistId") artistId: String,
               @Query("offset") offset: Int?,
               @Query("limit") limit: Int?): Observable<Albums>

    @GET("albums/{albumId}/tracks")
    fun tracks(@Path("albumId") albumId: String,
               @Query("offset") offset: Int?,
               @Query("limit") limit: Int?): Observable<Tracks>

    @GET("artists/{artistId}/top-tracks")
    fun topTracks(@Path("artistId") artistId: String,
                  @Query("country") country: String): Observable<TopTracksResponse>

    @GET("artists/{artistId}/related-artists")
    fun relatedArtists(@Path("artistId") artistId: String,
                       @Query("offset") offset: Int?,
                       @Query("limit") limit: Int?): Observable<SearchResponse>
}
