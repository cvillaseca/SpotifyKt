package com.cvillaseca.spotifykt.login.presentation.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme

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
        modifier = modifier
    ) {
        Column {
            Surface(
                modifier = Modifier.preferredSize(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                // Image goes here
            }
            Text(name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpotifyKtTheme {
        HomeCarouselItem(
            id = 1,
            name = "Music",
            image = ""
        ) {
        }
    }
}
