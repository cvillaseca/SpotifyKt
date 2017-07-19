package com.cvillaseca.spotifykt.data.entity

import com.google.gson.annotations.SerializedName
import com.cvillaseca.spotifykt.app.base.data.entity.Entity

class TrackEntity : Entity {

    @SerializedName("id")
    override val id: String? = null

    @SerializedName("album")
    internal var album: AlbumEntity? = null
        get
        set
    @SerializedName("artists")
    internal var artists: List<ArtistEntity>? = null
        get
        set
    @SerializedName("available_markets")
    internal var availableMarkets: List<String>? = null
        get
        set
    @SerializedName("disc_number")
    internal var discNumber: Int? = null
        get
        set
    @SerializedName("duration_ms")
    internal var durationMs: Int? = null
        get
        set
    @SerializedName("explicit")
    internal var explicit: Boolean? = null
        get
        set
    @SerializedName("external_urls")
    internal var externalUrls: ExternalUrls? = null
        get
        set
    @SerializedName("href")
    internal var href: String? = null
        get
        set
    @SerializedName("name")
    internal var name: String? = null
        get
        set
    @SerializedName("popularity")
    internal var popularity: Int? = null
        get
        set
    @SerializedName("preview_url")
    internal var previewUrl: String? = null
        get
        set
    @SerializedName("track_number")
    internal var trackNumber: Int? = null
        get
        set
    @SerializedName("type")
    internal var type: String? = null
        get
        set
    @SerializedName("uri")
    internal var uri: String? = null
        get
        set
}