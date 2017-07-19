package com.cvillaseca.spotifykt.data.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.data.entity.AlbumEntity
import com.cvillaseca.spotifykt.domain.dto.AlbumDto
import javax.inject.Inject

class AlbumEntityDtoMapper @Inject
constructor(private val artistEntityDtoMapper: ArtistEntityDtoMapper, private val imageEntityDtoMapper: ImageEntityDtoMapper) : BaseMapper<AlbumEntity, AlbumDto>() {


    override fun map1(o2: AlbumDto?): AlbumEntity? {
        val albumEntity = AlbumEntity()
        albumEntity.id = o2?.id
        albumEntity.name = o2?.name
        albumEntity.albumType = o2?.albumType
        albumEntity.artists = artistEntityDtoMapper.map1(o2?.artists)
        albumEntity.images = imageEntityDtoMapper.map1(o2?.images)

        return albumEntity
    }

    override fun map2(o1: AlbumEntity?): AlbumDto? {
        val albumDto = AlbumDto(o1?.id,
                o1?.name,
                o1?.albumType,
                artistEntityDtoMapper.map2(o1?.artists),
                imageEntityDtoMapper.map2(o1?.images))
        return albumDto
    }

}