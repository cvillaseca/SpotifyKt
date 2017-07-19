package com.cvillaseca.spotifykt.presentation.mvp.model

import android.os.Parcel
import android.os.Parcelable

data class AlbumModel (
        var id: String?,
        var name: String?,
        var artist: List<String>?,
        var images: List<ImageModel>?): Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<AlbumModel> = object : Parcelable.Creator<AlbumModel> {
            override fun createFromParcel(source: Parcel): AlbumModel = AlbumModel(source)
            override fun newArray(size: Int): Array<AlbumModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.createStringArrayList(),
    source.createTypedArrayList(ImageModel.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeStringList(artist)
        dest.writeTypedList(images)
    }
}
