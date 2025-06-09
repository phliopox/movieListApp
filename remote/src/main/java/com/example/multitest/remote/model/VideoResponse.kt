package com.example.multitest.remote.model

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("key")
    val key: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("type")
    val type: String,
)
