package com.cvillaseca.spotifykt.login.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.cvillaseca.spotifykt.login.presentation.view.HomeCategoryCarouselItem
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyKtTheme {
                Column {
                    TopAppBar(
                        title = {
                            Text(text = "Page title", maxLines = 2)
                        },
                        navigationIcon = {
                        }
                    )
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {

                        ScrollableRow {
                            (0..9).forEach {
                                HomeCategoryCarouselItem(
                                    it,
                                    "Music",
                                    ""
                                ) {
                                    Toast.makeText(this@LoginActivity, "touched!", Toast.LENGTH_LONG).show()
                                }
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