package com.vk.chillify.data.model

import com.google.gson.annotations.SerializedName

data class AlbumsResponse(
    @SerializedName("albums")
    val albums: Albums
)

data class Albums(
    @SerializedName("items")
    val items: List<AlbumItem>
)

data class AlbumItem(
    @SerializedName("artists")
    val artists: List<ArtistResponse>,

    @SerializedName("name")
    val albumName: String,

    @SerializedName("images")
    val images: List<Image>,

    @SerializedName("external_urls")
    val externalUrls: ExternalUrl
)
