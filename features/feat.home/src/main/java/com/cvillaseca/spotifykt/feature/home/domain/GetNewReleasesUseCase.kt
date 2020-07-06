package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import com.cvillaseca.spotifykt.data.response.NewReleasesResponse
import io.reactivex.Single
import javax.inject.Inject

class GetNewReleasesUseCase @Inject constructor(
    private val api: SpotifyApi
) : () -> Single<NewReleasesResponse> {

    override fun invoke(): Single<NewReleasesResponse> =
        api.newReleases("US", null,null)
}