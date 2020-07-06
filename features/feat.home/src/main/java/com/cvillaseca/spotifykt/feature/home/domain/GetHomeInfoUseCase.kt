package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import com.cvillaseca.spotifykt.data.response.CategoryResponse
import com.cvillaseca.spotifykt.data.response.NewReleasesResponse
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class GetHomeInfoUseCase @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getNewReleasesUseCase: GetNewReleasesUseCase
) : () -> Single<HomeDomainModel> {

    override fun invoke(): Single<HomeDomainModel> =
        Single.zip(
            getCategoriesUseCase.invoke(),
            getNewReleasesUseCase.invoke(),
            BiFunction { t1: CategoriesResponse, t2: NewReleasesResponse ->
                HomeDomainModel(t1.categories.items, t2.albums.items)
            }
        )
}

data class HomeDomainModel(
    val categories: List<CategoryResponse>,
    val newReleases: List<AlbumResponse>
)
