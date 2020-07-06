package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import io.reactivex.Single
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val api: SpotifyApi
) : () -> Single<CategoriesResponse> {

    override fun invoke(): Single<CategoriesResponse> =
        api.categories("US", "en_US", null, null)
}