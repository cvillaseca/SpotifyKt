package com.cvillaseca.spotifykt.feature.home.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvillaseca.spotifykt.feature.home.presentation.view.HomeCarouselItem
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val titles = listOf("Music", "Music2", "Music3", "Music4")
    Scaffold(
        topBar = {
            HomeToolbar()
        }
    ) {
        LazyColumn {
            items(10) {
                LazyRow {
                    itemsIndexed(titles) { index, item ->
                        HomeCarouselItem(
                            modifier = if (index == 0) Modifier.padding(16.dp)
                            else Modifier
                                .padding(vertical = 16.dp)
                                .padding(end = 16.dp),
                            id = index,
                            name = item,
                            image = "https://upload.wikimedia.org/wikipedia/en/4/4b/AmongUsWhiteKillBlue.png"
                        ) {
                            Toast.makeText(context, "touched!", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeToolbar() {
    TopAppBar(
        title = {
            Text(text = "SpotifyKt", maxLines = 1)
        },
        actions = {
            IconButton(
                onClick = { /* todo */ },
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpotifyKtTheme {
        HomeScreen()
    }
}
