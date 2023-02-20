package com.cvillaseca.spotifykt.feature.home.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            val state by viewModel.uiState.collectAsState()
            SpotifyKtTheme {
                HomeScreen(state, object: HomeAction {
                    override fun onSearchClick() {
                    }

                    override fun onFeatureClick() {
                        TODO("Not yet implemented")
                    }

                    override fun onCategoryClick() {
                        TODO("Not yet implemented")
                    }

                    override fun onNewReleaseClick() {
                        TODO("Not yet implemented")
                    }

                } )
            }
        }
    }
}
