package com.cvillaseca.spotifykt.feature.home.domain

import com.cvillaseca.spotifykt.data.SpotifyApi
import com.cvillaseca.spotifykt.data.response.CategoriesResponse
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse
import com.cvillaseca.spotifykt.data.response.NewReleasesResponse
import com.cvillaseca.spotifykt.testtools.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


internal class GetHomeInfoUseCaseTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val mockSpotifyApi = mockk<SpotifyApi>()

    private lateinit var useCase: GetHomeInfoUseCase

    @Before
    fun setup() {
        useCase = GetHomeInfoUseCase(mockSpotifyApi)
    }

    @Test
    fun `When the home screen loads, the info required is returned`() {
        val expectedCategories = mockk<CategoriesResponse>(relaxed = true)
        val expectedNewReleases = mockk<NewReleasesResponse>(relaxed = true)
        val expectedPlaylists = mockk<FeaturedPlaylistsResponse>(relaxed = true)

        coEvery {
            mockSpotifyApi.categories(any(), any(), any(), any())
        } returns expectedCategories

        coEvery {
            mockSpotifyApi.newReleases(any(), any(), any())
        } returns expectedNewReleases

        coEvery {
            mockSpotifyApi.featuredPlaylists(any(), any(), any(), any(), any())
        } returns expectedPlaylists

        runTest {
            val homeDomainModel = useCase.run()
            assertEquals(expectedCategories.categories.items, homeDomainModel.categories)
            assertEquals(expectedNewReleases.albums.items, homeDomainModel.newReleases)
            assertEquals(expectedPlaylists, homeDomainModel.featuredPlaylists)
        }

    }

}
