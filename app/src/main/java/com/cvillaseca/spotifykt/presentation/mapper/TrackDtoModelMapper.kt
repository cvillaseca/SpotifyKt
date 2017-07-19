package com.cvillaseca.spotifykt.presentation.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.domain.dto.TrackDto
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel
import javax.inject.Inject

class TrackDtoModelMapper @Inject
constructor(private val artistDtoModelMapper: ArtistDtoModelMapper,
            private val albumDtoModelMapper: AlbumDtoModelMapper) : BaseMapper<TrackDto, TrackModel>() {

    override fun map1(o2: TrackModel?): TrackDto? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun map2(o1: TrackDto?): TrackModel? {
        val albumModel = TrackModel(
                o1?.id,
                o1?.name,
                artistDtoModelMapper.map2(o1?.artists),
                albumDtoModelMapper.map2(o1?.album!!),
                o1.durationMs,
                o1.popularity,
                o1.previewUrl
        )

        return albumModel
    }

}