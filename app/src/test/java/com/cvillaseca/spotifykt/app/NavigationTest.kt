package com.cvillaseca.spotifykt.app

import com.cvillaseca.spotifykt.navigation.features.SearchNavigation
import com.cvillaseca.spotifykt.search.presentation.SearchFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class NavigationTest(private val navigation: String, private val canonicalName: String) {

    @Test
    fun `navigation name matches canonical class name`() {
        assert(navigation == canonicalName) {
            "$navigation != $canonicalName"
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(SearchNavigation.SEARCH_ACTIVITY_NAME, SearchFragment::class.java.canonicalName)
        )
    }
}
