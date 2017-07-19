package com.cvillaseca.spotifykt.domain.dto

data class AlbumDto(val id: String?,
                    val name: String?,
                    val albumType: String?,
                    val artists: List<ArtistDto>?,
                    val images: List<ImageDto>?){
}