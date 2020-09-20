package com.cvillaseca.spotifykt.login.presentation.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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
        modifier = modifier.padding(0.dp)
    ) {
        Stack(
            modifier = Modifier.padding(0.dp)
        ) {
            CoilImage(
                data = image,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp).padding(0.dp)
            )
            Text(
                text = name,
                modifier = Modifier.align(Alignment.BottomStart).padding(8.dp)
            )
        }

//
//        Column {
//            Surface(
//                modifier = Modifier.preferredSize(100.dp),
//                shape = CircleShape,
//                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
//            ) {
//                CoilImage(
//                    data = image,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//            }
//            Text(name)
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeCarouselPreview() {
    SpotifyKtTheme {
        HomeCarouselItem(
            id = 1,
            name = "Music",
            image = "https://upload.wikimedia.org/wikipedia/en/4/4b/AmongUsWhiteKillBlue.png"
        ) {
        }
    }
}
