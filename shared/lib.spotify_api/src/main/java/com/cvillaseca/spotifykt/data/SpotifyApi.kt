package com.cvillaseca.spotifykt.data

import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.ArtistResponse
import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse
import com.cvillaseca.spotifykt.data.response.NewReleasesResponse
import com.cvillaseca.spotifykt.data.response.PagedResponse
import com.cvillaseca.spotifykt.data.response.SearchResponse
import com.cvillaseca.spotifykt.data.response.TopTracksResponse
import com.cvillaseca.spotifykt.data.response.TrackEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApi {

    @Headers("Content-Type: application/x-www-form-urlencoded")

    @GET("search")
    fun search(
        @Query("query") query: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("type") type: String,
        @Query("market") market: String
    ): Single<SearchResponse>

    @GET("artists/{artistId}")
    fun artist(@Path("artistId") artistId: String): Single<ArtistResponse>

    @GET("albums/{albumId}")
    fun album(@Path("albumId") albumId: String): Single<AlbumResponse>

    @GET("artists/{artistId}/albums")
    fun albums(
        @Path("artistId") artistId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Single<PagedResponse<AlbumResponse>>

    @GET("albums/{albumId}/tracks")
    fun tracks(
        @Path("albumId") albumId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Single<PagedResponse<TrackEntity>>

    @GET("artists/{artistId}/top-tracks")
    fun topTracks(
        @Path("artistId") artistId: String,
        @Query("country") country: String
    ): Single<TopTracksResponse>

    @GET("artists/{artistId}/related-artists")
    fun relatedArtists(
        @Path("artistId") artistId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Single<SearchResponse>

    @GET("browse/categories")
    fun categories(
        @Query("country") country: String,
        @Query("locale") locale: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Single<CategoriesResponse>

    @GET("browse/new-releases")
    fun newReleases(
        @Query("country") country: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Single<NewReleasesResponse>

    @GET("browse/featured-playlists")
    fun featuredPlaylists(
        @Query("country") country: String,
        @Query("locale") locale: String,
        // Format yyyy-MM-ddTHH:mm:ss
        @Query("timestamp") timestamp: String?,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Single<FeaturedPlaylistsResponse>
}
