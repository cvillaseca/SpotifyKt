package com.cvillaseca.spotifykt.feature.home.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeCarouselItem(
    modifier: Modifier = Modifier,
    id: Int,
    name: String,
    image: String,
    onClick: (Int) -> Unit
) {

    Button(
        onClick = { onClick(id) },
        modifier = modifier,
        contentPadding = PaddingValues(0.dp)
    ) {
        Card {
            Column(
                modifier = Modifier.width(140.dp)
            ) {
                CoilImage(
                    data = image,
                    contentDescription = null,
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
