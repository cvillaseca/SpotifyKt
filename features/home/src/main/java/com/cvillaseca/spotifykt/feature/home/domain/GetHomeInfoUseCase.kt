package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.CategoryResponse
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class GetHomeInfoUseCase @Inject constructor(
    private val api: SpotifyApi
): suspend () -> HomeDomainModel {

    override suspend fun invoke(): HomeDomainModel =
        HomeDomainModel(
            api.categories("US", "en_US", null, null).categories.items,
            api.newReleases("US", null, null).albums.items,
            getPlaylists()
        )

    private suspend fun getPlaylists(): FeaturedPlaylistsResponse {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        val timestamp = dateFormat.format(Date())
        return api.featuredPlaylists("US", "en_US", timestamp, null, null)
    }
}

data class HomeDomainModel(
    val categories: List<CategoryResponse>,
    val newReleases: List<AlbumResponse>,
    val featuredPlaylists: FeaturedPlaylistsResponse
)
