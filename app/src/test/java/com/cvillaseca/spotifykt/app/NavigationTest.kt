package com.cvillaseca.spotifykt.app

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
        fun data() = listOf<String>(
//            arrayOf(SearchNavigation.SEARCH_ACTIVITY_NAME, SearchFragment::class.java.canonicalName)
        )
    }
}
