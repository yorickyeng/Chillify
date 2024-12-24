package com.vk.chillify.data.model

import com.google.gson.annotations.SerializedName

data class ArtistsResponse(

    @SerializedName("artists")
    val artists: List<ArtistResponse>
)

data class ArtistResponse(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("genres")
    val genres: List<String>,

    @SerializedName("images")
    val images: List<Image>?
)

data class Image(

    @SerializedName("url")
    val url: String,

    @SerializedName("height")
    val height: Int?,

    @SerializedName("width")
    val width: Int?
)