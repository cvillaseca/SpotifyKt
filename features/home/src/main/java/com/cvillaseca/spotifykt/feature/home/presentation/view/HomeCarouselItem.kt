package com.cvillaseca.spotifykt.feature.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeCarouselItem(
    modifier: Modifier = Modifier,
    id: Int,
    name: String,
    image: String?,
    onClick: (Int) -> Unit
) {
    Card(
        onClick = { onClick(id) },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.width(140.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = image,
                ),
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(140.dp)
                    .padding(0.dp)
            )
            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(8.dp),
                maxLines = 2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeCarouselPreview() {
    SpotifyKtTheme {
        HomeCarouselItem(
            id = 1,
            name = "Music with long title",
            image = "https://upload.wikimedia.org/wikipedia/en/4/4b/AmongUsWhiteKillBlue.png"
        ) {
        }
    }
}
