package com.example.multitest.remote.model

import com.example.multitest.data.model.GenreEntity
import com.example.multitest.remote.RemoteMapper
import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
) : RemoteMapper<GenreEntity>{
    override fun toData(): GenreEntity = GenreEntity(id, name)
}