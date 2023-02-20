package com.cvillaseca.spotifykt.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cvillaseca.spotifykt.feature.home.presentation.view.HomeCarouselItem
import com.cvillaseca.spotifykt.presentation.state.resolve
import com.cvillaseca.spotifykt.view.ui.typography

@Composable
fun HomeScreen(state: HomeState, action: HomeAction) {
    Scaffold(
        topBar = {
            HomeToolbar { action.onSearchClick() }
        }
    ) {
        if (state.isLoading) {
            Column(
                Modifier
                    .padding(it)
                    .fillMaxSize()) {
                Text(text = "loading")
                CircularProgressIndicator()
            }
        } else {
            HomeContent(
                modifier = Modifier.padding(it),
                featured = state.featured,
                categories = state.categories,
                newReleases = state.newReleases,
                action = action
            )
        }
    }
}

@Suppress("MagicNumber")
@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
    featured: Section?,
    categories: Section?,
    newReleases: Section?,
    action: HomeAction
) {
    Column(modifier = modifier) {
        featured?.let {
            HomeSection(
                name = it.name.resolve(),
                items = it.items,
                onItemClick = { action.onFeatureClick() })
        }
        categories?.let {
            HomeSection(
                name = it.name.resolve(),
                items = it.items,
                onItemClick = { action.onFeatureClick() })
        }
        newReleases?.let {
            HomeSection(
                name = it.name.resolve(),
                items = it.items,
                onItemClick = { action.onFeatureClick() }
            )
        }
    }
}

@Composable
private fun HomeSection(name: String, items: List<Item>, onItemClick: (String) -> Unit) {
    SectionTitle(text = name)
    LazyRow {
        itemsIndexed(items) { index, item ->
            HomeCarouselItem(
                modifier = if (index == 0) Modifier.padding(16.dp)
                else Modifier
                    .padding(vertical = 16.dp)
                    .padding(end = 16.dp),
                id = index,
                name = item.name,
                image = item.image
            ) {
                onItemClick(item.id)
            }
        }
    }
}

@Composable
fun HomeToolbar(onSearchClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "SpotifyKt", maxLines = 1, style = typography.h5)
        },
        actions = {
            IconButton(
                onClick = { onSearchClick() },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = "Search"
                )
            }
        }
    )
}

@Suppress("MagicNumber")
@Composable
private fun SectionTitle(text: String) {
    Text(text = text, style = typography.h5, modifier = Modifier.padding(horizontal = 16.dp))
}

// @Preview(showBackground = true)
// @Composable
// fun DefaultPreview() {
//    SpotifyKtTheme {
//        HomeScreen(viewModel.collectState())
//    }
// }
