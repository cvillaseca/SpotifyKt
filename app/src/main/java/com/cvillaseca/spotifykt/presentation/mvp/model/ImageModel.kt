package com.cvillaseca.spotifykt.presentation.mvp.model

import android.os.Parcel
import android.os.Parcelable

data class ImageModel (
        var url: String?,
        var width: Int?,
        var height: Int?): Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ImageModel> = object : Parcelable.Creator<ImageModel> {
            override fun createFromParcel(source: Parcel): ImageModel = ImageModel(source)
            override fun newArray(size: Int): Array<ImageModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(url)
        dest.writeValue(width)
        dest.writeValue(height)
    }
}