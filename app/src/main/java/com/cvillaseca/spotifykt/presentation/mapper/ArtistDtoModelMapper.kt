package com.cvillaseca.spotifykt.presentation.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.domain.dto.ArtistDto
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import javax.inject.Inject

class ArtistDtoModelMapper @Inject
constructor(private val imageDtoModelMapper: ImageDtoModelMapper) : BaseMapper<ArtistDto, ArtistModel>() {

    override fun map1(o2: ArtistModel?): ArtistDto? {
        //unused
        return ArtistDto(null,null,null)
    }

    override fun map2(o1: ArtistDto?): ArtistModel? {
        val artistModel = ArtistModel(o1?.id,
                o1?.name,
                imageDtoModelMapper.map2(o1?.imageDtoList?.firstOrNull()),
                imageDtoModelMapper.map2(o1?.imageDtoList?.firstOrNull()))

        return artistModel
    }

}