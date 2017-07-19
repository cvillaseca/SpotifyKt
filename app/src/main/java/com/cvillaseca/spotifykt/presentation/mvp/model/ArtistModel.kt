package com.cvillaseca.spotifykt.presentation.mvp.model

import android.os.Parcel
import android.os.Parcelable



data class ArtistModel (
    var id: String?,
    var name: String?,
    var thumbnail: ImageModel?,
    var image: ImageModel?): Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ArtistModel> = object : Parcelable.Creator<ArtistModel> {
            override fun createFromParcel(source: Parcel): ArtistModel = ArtistModel(source)
            override fun newArray(size: Int): Array<ArtistModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.readParcelable<ImageModel>(ImageModel::class.java.classLoader),
    source.readParcelable<ImageModel>(ImageModel::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeParcelable(thumbnail, 0)
        dest.writeParcelable(image, 0)
    }
}