package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val categories: PagedResponse<CategoryResponse>
)
