package com.cvillaseca.spotifykt.feature.home.presentation

import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import com.cvillaseca.spotifykt.feature.home.domain.HomeDomainModel
import javax.inject.Inject

class HomeReducer @Inject constructor() {

    fun toState(
        domainModel: HomeDomainModel
    ) = HomeInfo(
        categories = domainModel.categories,
        newReleases = domainModel.newReleases
    )
}
