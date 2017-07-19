package com.cvillaseca.spotifykt.data.audio

import android.media.MediaPlayer
import android.util.Log
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel
import java.io.IOException
import javax.inject.Inject


class AudioController @Inject constructor() {

    private var isPLAYING: Boolean = false
    private var mp: MediaPlayer? = null

    fun startAudio(trackModel: TrackModel) {

        if (isPLAYING) {
            isPLAYING = false
            stopPlaying()
        }

        isPLAYING = true
        mp = MediaPlayer()
        try {
            mp!!.setDataSource(trackModel.previewUrl)
            mp!!.prepare()
            mp!!.start()
        } catch (e: IOException) {
            Log.e(javaClass.simpleName, "prepare() failed")
        }

    }

    private fun stopPlaying() {
        mp!!.release()
        mp = null
    }
}
