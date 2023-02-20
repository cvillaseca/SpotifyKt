package com.cvillaseca.spotifykt.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvillaseca.spotifykt.feature.home.R
import com.cvillaseca.spotifykt.feature.home.domain.GetHomeInfoUseCase
import com.cvillaseca.spotifykt.feature.home.domain.HomeDomainModel
import com.cvillaseca.spotifykt.presentation.state.StringResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetHomeInfoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(isLoading = true))
    val uiState: StateFlow<HomeState>
        get() = _state.asStateFlow()

    init {
        loadInfo()
    }

    private fun loadInfo() {
        viewModelScope.launch {
            _state.value = useCase().toUIState()
        }
    }

    private fun HomeDomainModel.toUIState(): HomeState {
        val featured = Section(
            name = StringResource.Raw(featuredPlaylists.message),
            items = featuredPlaylists.playlists.items.map {
                Item(it.id, it.name, it.images.firstOrNull()?.url)
            }
        )

        val categories = Section(
            name = StringResource.Id(R.string.categories),
            items = categories.map {
                Item(it.id, it.name, it.icons.firstOrNull()?.url)
            }
        )

        val newReleases = Section(
            name = StringResource.Id(R.string.new_releases),
            items = newReleases.map {
                Item(it.id, it.name, it.images.firstOrNull()?.url)
            }
        )

        return HomeState(
            featured = featured,
            categories = categories,
            newReleases = newReleases
        )
    }
}
