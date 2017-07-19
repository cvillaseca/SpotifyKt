package com.cvillaseca.spotifykt.data.entity

import com.google.gson.annotations.SerializedName

open class PagedResponse<T> {

    @SerializedName("offset")
    internal var offset: Int? = null
        get
        set
    @SerializedName("next")
    internal var next: String? = null
        get
        set
    @SerializedName("href")
    internal var href: String? = null
        get
        set
    @SerializedName("limit")
    internal var limit: Int? = null
        get
        set
    @SerializedName("previous")
    internal var previous: Any? = null
        get
        set
    @SerializedName("total")
    internal var total: Int? = null
        get
        set
    @SerializedName("items")
    internal var items: List<T>? = null
        get
        set
}