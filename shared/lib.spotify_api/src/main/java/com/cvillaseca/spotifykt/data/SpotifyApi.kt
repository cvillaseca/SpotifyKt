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
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApi {

    @Headers("Content-Type: application/x-www-form-urlencoded")

    @GET("search")
    suspend fun search(
        @Query("query") query: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("type") type: String,
        @Query("market") market: String
    ): SearchResponse

    @GET("artists/{artistId}")
    suspend fun artist(@Path("artistId") artistId: String): ArtistResponse

    @GET("albums/{albumId}")
    suspend fun album(@Path("albumId") albumId: String): AlbumResponse

    @GET("artists/{artistId}/albums")
    suspend fun albums(
        @Path("artistId") artistId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): PagedResponse<AlbumResponse>

    @GET("albums/{albumId}/tracks")
    suspend fun tracks(
        @Path("albumId") albumId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): PagedResponse<TrackEntity>

    @GET("artists/{artistId}/top-tracks")
    suspend fun topTracks(
        @Path("artistId") artistId: String,
        @Query("country") country: String
    ): TopTracksResponse

    @GET("artists/{artistId}/related-artists")
    suspend fun relatedArtists(
        @Path("artistId") artistId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): SearchResponse

    @GET("browse/categories")
    suspend fun categories(
        @Query("country") country: String,
        @Query("locale") locale: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): CategoriesResponse

    @GET("browse/new-releases")
    suspend fun newReleases(
        @Query("country") country: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): NewReleasesResponse

    @GET("browse/featured-playlists")
    suspend fun featuredPlaylists(
        @Query("country") country: String,
        @Query("locale") locale: String,
        // Format yyyy-MM-ddTHH:mm:ss
        @Query("timestamp") timestamp: String?,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): FeaturedPlaylistsResponse
}
