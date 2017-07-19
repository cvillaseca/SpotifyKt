package com.cvillaseca.spotifykt.data.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.data.entity.ArtistEntity
import com.cvillaseca.spotifykt.domain.dto.ArtistDto
import javax.inject.Inject

class ArtistEntityDtoMapper @Inject
constructor(private val imageEntityDtoMapper: ImageEntityDtoMapper) : BaseMapper<ArtistEntity, ArtistDto>() {

    override fun map1(o2: ArtistDto?): ArtistEntity? {
        val artistEntity = ArtistEntity()

        artistEntity.id = o2?.id
        artistEntity.name = o2?.name
        artistEntity.images = imageEntityDtoMapper.map1(o2?.imageDtoList)

        return artistEntity
    }

    override fun map2(o1: ArtistEntity?): ArtistDto? {
        val artistDto = ArtistDto(
                o1?.id,
                o1?.name,
                imageEntityDtoMapper.map2(o1?.images))
        return artistDto
    }
}