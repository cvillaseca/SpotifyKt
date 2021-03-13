package com.cvillaseca.spotifykt.feature.home.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Incomplete
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.compose.collectAsState
import com.cvillaseca.spotifykt.feature.home.domain.HomeDomainModel
import com.cvillaseca.spotifykt.feature.home.presentation.view.HomeCarouselItem

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    val state by viewModel.collectAsState()
    Scaffold(
        topBar = {
            HomeToolbar(viewModel)
        }
    ) {
        when (state.homeInfo) {
            is Incomplete -> {
                Text(text = "loading")
                CircularProgressIndicator()
            }
            is Success -> {
                renderSuccess(state.homeInfo()!!, context)
            }
            is Fail -> {
                Text(text = (state.homeInfo as Fail<HomeDomainModel>).error.message ?: "Error without description")
            }
        }
    }
}

@Suppress("MagicNumber")
@Composable
private fun renderSuccess(homeInfo: HomeDomainModel, context: Context) {
    LazyColumn {
        items(1) {
            Spacer(modifier = Modifier.padding(top = 16.dp))
            SectionTitle(text = homeInfo.featuredPlaylists.message)
            LazyRow {
                itemsIndexed(homeInfo.featuredPlaylists.playlists.items) { index, item ->
                    HomeCarouselItem(
                        modifier = if (index == 0) Modifier.padding(16.dp)
                        else Modifier
                            .padding(vertical = 16.dp)
                            .padding(end = 16.dp),
                        id = index,
                        name = item.name,
                        image = item.images.first().url
                    ) {
                        Toast.makeText(context, "touched!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
            SectionTitle(text = "Categories")
            LazyRow {
                itemsIndexed(homeInfo.categories) { index, item ->
                    HomeCarouselItem(
                        modifier = if (index == 0) Modifier.padding(16.dp)
                        else Modifier
                            .padding(vertical = 16.dp)
                            .padding(end = 16.dp),
                        id = index,
                        name = item.name,
                        image = item.icons.first().url
                    ) {
                        Toast.makeText(context, "touched!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
            SectionTitle(text = "New Releases")
            LazyRow {
                itemsIndexed(homeInfo.newReleases) { index, item ->
                    HomeCarouselItem(
                        modifier = if (index == 0) Modifier.padding(16.dp)
                        else Modifier
                            .padding(vertical = 16.dp)
                            .padding(end = 16.dp),
                        id = index,
                        name = item.name,
                        image = item.images.first().url
                    ) {
                        Toast.makeText(context, "touched!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeToolbar(viewModel: HomeViewModel) {
    TopAppBar(
        title = {
            Text(text = "SpotifyKt", maxLines = 1)
        },
        actions = {
            IconButton(
                onClick = { viewModel.loadInfo() },
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
    Text(text = text, modifier = Modifier.padding(horizontal = 16.dp))
}

// @Preview(showBackground = true)
// @Composable
// fun DefaultPreview() {
//    SpotifyKtTheme {
//        HomeScreen(viewModel.collectState())
//    }
// }
