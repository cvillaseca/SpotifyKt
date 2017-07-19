package com.cvillaseca.spotifykt.presentation.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.domain.dto.ImageDto
import com.cvillaseca.spotifykt.presentation.mvp.model.ImageModel
import javax.inject.Inject

class ImageDtoModelMapper @Inject
constructor() : BaseMapper<ImageDto, ImageModel>() {

    override fun map1(o2: ImageModel?): ImageDto? {
        val imageDto = ImageDto(
                o2?.url,
                o2?.width,
                o2?.height)
        return imageDto
    }

    override fun map2(o1: ImageDto?): ImageModel? {
        val imageDto = ImageModel(
                o1?.url,
                o1?.width,
                o1?.height)
        return imageDto
    }

}
