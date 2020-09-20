package com.cvillaseca.spotifykt.login.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.RowScope.align
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.cvillaseca.spotifykt.login.presentation.view.HomeCarouselItem
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyKtTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "SpotifyKt", maxLines = 1)
                            },
//                            actions = {
//                                IconButton(
//                                    onClick = { /* todo */ },
//                                    modifier = Modifier.align(Alignment.CenterVertically)
//                                ) {
//                                    Icon(
//                                        asset = Icons.Outlined.Add,
//                                    )
//                                }
//                            }
                        )
                    }
                ) {
                    ScrollableRow {
                        (0..9).forEachIndexed { index, it ->
                            HomeCarouselItem(
                                modifier = if (index == 0) Modifier.padding(16.dp)
                                else Modifier.padding(vertical = 16.dp).padding(end = 16.dp),
                                id = it,
                                name = "Music",
                                image = "https://upload.wikimedia.org/wikipedia/en/4/4b/AmongUsWhiteKillBlue.png"
                            ) {
                                Toast.makeText(this@LoginActivity, "touched!", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpotifyKtTheme {
        Greeting("Android")
    }
}