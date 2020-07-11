package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import com.cvillaseca.spotifykt.data.response.CategoryResponse
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse
import com.cvillaseca.spotifykt.data.response.NewReleasesResponse
import io.reactivex.Single
import io.reactivex.functions.Function3
import javax.inject.Inject

class GetHomeInfoUseCase @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getNewReleasesUseCase: GetNewReleasesUseCase,
    private val getFeaturedPlaylistsUseCase: GetFeaturedPlaylistsUseCase
) : () -> Single<HomeDomainModel> {

    override fun invoke(): Single<HomeDomainModel> =
        Single.zip(
            getCategoriesUseCase.invoke(),
            getNewReleasesUseCase.invoke(),
            getFeaturedPlaylistsUseCase.invoke(),
            Function3 { t1: CategoriesResponse,
                        t2: NewReleasesResponse,
                        t3: FeaturedPlaylistsResponse ->
                HomeDomainModel(t1.categories.items, t2.albums.items, t3)
            }
        )
}

data class HomeDomainModel(
        val categories: List<CategoryResponse>,
        val newReleases: List<AlbumResponse>,
        val featuredPlaylists: FeaturedPlaylistsResponse
)
