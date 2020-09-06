package com.cvillaseca.spotifykt.login.presentation.view

import android.widget.Toast
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.cvillaseca.spotifykt.login.presentation.Greeting
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme

@Composable
fun HomeCategoryCarouselItem(
    id: Int,
    name: String,
    image: String,
    onClick: (Int) -> Unit
) {
    Button(
        onClick = { onClick(id) },
        modifier = Modifier.padding(16.dp)
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
        HomeCategoryCarouselItem(
            1,
            "Music",
            ""
        ) {
        }
    }
}

//@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT, saveViewState = true)
//class HomeCategoryCarouselItem @JvmOverloads constructor(
//    context: Context,
//    attrs: AttributeSet? = null,
//    defStyleAttr: Int = 0
//) : CardView(context, attrs, defStyleAttr) {
//
//    init {
//        radius = resources.getDimension(R.dimen.margin_small)
//        View.inflate(context, R.layout.view_category_item, this)
//    }
//
//    @ModelProp
//    fun setName(cityName: String) {
//        name.text = cityName
//    }
//
//    @ModelProp
//    fun setImage(url: String) =
//        image.loadImage(url)
//
//    @CallbackProp
//    fun setClickListener(listener: View.OnClickListener?) {
//        setOnClickListener(listener)
//    }
//}
