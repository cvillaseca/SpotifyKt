package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse
import io.reactivex.Single
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class GetFeaturedPlaylistsUseCase @Inject constructor(
    private val api: SpotifyApi
) : () -> Single<FeaturedPlaylistsResponse> {

    override fun invoke(): Single<FeaturedPlaylistsResponse> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        val timestamp = dateFormat.format(Date())
        return api.featuredPlaylists("US", "en_US", timestamp, null, null)
    }
}
