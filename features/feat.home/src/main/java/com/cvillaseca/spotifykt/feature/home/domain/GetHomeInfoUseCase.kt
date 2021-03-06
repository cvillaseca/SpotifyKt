package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.CategoryResponse
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class GetHomeInfoUseCase @Inject constructor(
    private val api: SpotifyApi
) : () -> Flow<HomeDomainModel> {

    override fun invoke(): Flow<HomeDomainModel> = combine(
        flow { emit(api.categories("US", "en_US", null, null)) },
        flow { emit(api.newReleases("US", null, null)) },
        flow { emit(getPlaylists()) }
    ) { t1, t2, t3 ->
        HomeDomainModel(t1.categories.items, t2.albums.items, t3)
    }

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
