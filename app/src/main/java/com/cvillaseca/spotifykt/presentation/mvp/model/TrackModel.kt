package com.cvillaseca.spotifykt.presentation.mvp.model

import android.os.Parcel
import android.os.Parcelable


data class TrackModel (
        var id: String?,
        var name: String?,
        var artists: List<ArtistModel>?,
        var album: AlbumModel?,
        var durationMs: Int?,
        var popularity: Int?,
        var previewUrl: String?) : Parcelable{

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<TrackModel> = object : Parcelable.Creator<TrackModel> {
            override fun createFromParcel(source: Parcel): TrackModel = TrackModel(source)
            override fun newArray(size: Int): Array<TrackModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.createTypedArrayList(ArtistModel.CREATOR),
    source.readParcelable<AlbumModel>(AlbumModel::class.java.classLoader),
    source.readValue(Int::class.java.classLoader) as Int?,
    source.readValue(Int::class.java.classLoader) as Int?,
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeTypedList(artists)
        dest.writeParcelable(album, 0)
        dest.writeValue(durationMs)
        dest.writeValue(popularity)
        dest.writeString(previewUrl)
    }
}
