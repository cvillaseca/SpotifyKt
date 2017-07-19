package com.cvillaseca.spotifykt.presentation.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.domain.dto.AlbumDto
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import javax.inject.Inject

class AlbumDtoModelMapper @Inject
constructor(private val imageDtoModelMapper: ImageDtoModelMapper) : BaseMapper<AlbumDto, AlbumModel>() {

    override fun map1(o2: AlbumModel?): AlbumDto? {
        val albumDto = AlbumDto(
                o2?.id,
                o2?.name,
                null,
                null,
                null)
        return albumDto
    }

    override fun map2(o1: AlbumDto?): AlbumModel? {
        val albumModel = AlbumModel(
                o1?.id,
                o1?.name,
                o1?.artists?.map { artistDto -> artistDto.name!! },
                imageDtoModelMapper.map2(o1?.images))

        return albumModel
    }
}
