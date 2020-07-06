package com.cvillaseca.spotifykt.feature.home.presentation

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.CategoryResponse
import com.cvillaseca.spotifykt.feature.home.R
import com.cvillaseca.spotifykt.feature.home.presentation.view.HomeCategoryCarouselItemModel_
import com.cvillaseca.spotifykt.feature.home.presentation.view.carouselView
import com.cvillaseca.spotifykt.view.Padding
import com.cvillaseca.spotifykt.view.PrimaryTextView
import com.cvillaseca.spotifykt.view.loading.carouselSkeletonView
import com.cvillaseca.spotifykt.view.primaryTextView

class HomeController(
    private val callbacks: AdapterCallbacks
) : TypedEpoxyController<Async<HomeInfo>>() {

    override fun buildModels(data: Async<HomeInfo>) {
        when (data) {
            is Loading -> {
                carouselSkeletonView { id("skeleton") }
                carouselSkeletonView { id("skeleton2") }
                carouselSkeletonView { id("skeleton3") }
            }
            is Success -> {
                renderCategories(data())
                renderNewReleases(data())
            }
        }
    }

    private fun renderCategories(data: HomeInfo) {
        data.categories
            .mapIndexed(categoryToEpoxyModel())
            .filterNotNull()
            .takeIf { it.isNotEmpty() }
            ?.let {
                primaryTextView {
                    id("categoryTitle")
                    body("Categories")
                    textStyle(PrimaryTextView.TextStyle.HEADER_XS)
                    color(R.color.grey_4)
                    padding(Padding.Single(R.dimen.margin_typical))
                }
                carouselView {
                    id("categoryCarousel")
                    hasFixedSize(true)
                    paddingRes(R.dimen.margin_typical)
                    models(it.toList())
                }
            }
    }

    private fun categoryToEpoxyModel(): (Int, CategoryResponse) -> HomeCategoryCarouselItemModel_? = { i, it ->
        HomeCategoryCarouselItemModel_()
            .id("Category$i")
            .name(it.name)
            .image(it.icons.first().url)
            .clickListener { _, _, _, position ->
                callbacks.onTopCityClick(position)
            }
    }

    private fun renderNewReleases(data: HomeInfo) {
        data.newReleases
            .mapIndexed(newReleaseToEpoxyModel())
            .filterNotNull()
            .takeIf { it.isNotEmpty() }
            ?.let {
                primaryTextView {
                    id("newReleaseTitle")
                    body("New Releases")
                    textStyle(PrimaryTextView.TextStyle.HEADER_XS)
                    color(R.color.grey_4)
                    padding(Padding.Single(R.dimen.margin_typical))
                }
                carouselView {
                    id("newReleaseCarousel")
                    hasFixedSize(true)
                    paddingRes(R.dimen.margin_typical)
                    models(it.toList())
                }
            }
    }

    private fun newReleaseToEpoxyModel(): (Int, AlbumResponse) -> HomeCategoryCarouselItemModel_? = { i, it ->
        HomeCategoryCarouselItemModel_()
            .id("NewRelease$i")
            .name(it.name)
            .image(it.images.first().url)
            .clickListener { _, _, _, position ->
                callbacks.onTopCityClick(position)
            }
    }

    interface AdapterCallbacks {
        fun onListCarClick()
        fun onTopCityClick(position: Int)
    }
}

