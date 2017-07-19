package com.cvillaseca.spotifykt.domain.dto

data class TrackDto (
        var id: String?,
        var album: AlbumDto?,
        var artists: List<ArtistDto>?,
        var durationMs: Int?,
        var name: String?,
        var popularity: Int?,
        var previewUrl: String? ) {
}
