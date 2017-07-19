package com.cvillaseca.spotifykt.data.mapper

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.data.entity.Image
import com.cvillaseca.spotifykt.domain.dto.ImageDto
import javax.inject.Inject

class ImageEntityDtoMapper @Inject
constructor() : BaseMapper<Image, ImageDto>() {

    override fun map1(o2: ImageDto?): Image? {
        val image = Image(
                o2?.url,
                o2?.width,
                o2?.height)
        return image
    }

    override fun map2(o1: Image?): ImageDto? {
        val imageDto = ImageDto(
                o1?.url,
                o1?.width,
                o1?.height)
        return imageDto
    }
}
