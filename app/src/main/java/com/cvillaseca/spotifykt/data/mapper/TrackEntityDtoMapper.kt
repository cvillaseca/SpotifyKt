package com.cvillaseca.spotifykt.data.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.data.entity.TrackEntity
import com.cvillaseca.spotifykt.domain.dto.TrackDto
import javax.inject.Inject

class TrackEntityDtoMapper @Inject
constructor(private val artistEntityDtoMapper: ArtistEntityDtoMapper,
            private val albumEntityDtoMapper: AlbumEntityDtoMapper,
            private val imageEntityDtoMapper: ImageEntityDtoMapper) : BaseMapper<TrackEntity, TrackDto>() {

    override fun map1(o2: TrackDto?): TrackEntity? {
        //unused
        return TrackEntity()
    }

    override fun map2(o1: TrackEntity?): TrackDto? {
        val trackDto = TrackDto(
                o1?.id,
                albumEntityDtoMapper.map2(o1?.album),
                artistEntityDtoMapper.map2(o1?.artists),
                o1?.durationMs,
                o1?.name,
                o1?.popularity,
                o1?.previewUrl)

        return trackDto
    }

}
