package com.cvillaseca.spotifykt.presentation.mvp

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.ui.activity.AlbumActivity
import com.cvillaseca.spotifykt.presentation.ui.activity.ArtistActivity
import javax.inject.Inject

class Navigator @Inject constructor() {

//    fun goToAlbumList(context: Context, artist: ArtistModel) {
//        val intent = Intent(context, AlbumListActivity::class.java)
//        val artistParcelable = Parcels.wrap(artist)
//        intent.putExtra(AlbumListActivity.ARG_ARTIST, artistParcelable)
//        context.startActivity(intent)
//    }
//
//    fun goToArtist(context: Context, artist: ArtistModel) {
//        val intent = Intent(context, ArtistActivity::class.java)
//        val artistParcelable = Parcels.wrap(artist)
//        intent.putExtra(ArtistActivity.ARG_ARTIST, artistParcelable)
//
//        context.startActivity(intent)
//    }
//
    fun goToArtistAnimated(activity: Activity, artist: ArtistModel, view: View) {
        val intent = Intent(activity, ArtistActivity::class.java)
        intent.putExtra(ArtistActivity.ARG_ARTIST, artist)

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, "artist")
        activity.startActivity(intent, options.toBundle())
    }

    fun goToAlbum(activity: Activity, album: AlbumModel) {
        val intent = Intent(activity, AlbumActivity::class.java)
        intent.putExtra(AlbumActivity.ARG_ALBUM, album)
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)

    }
}