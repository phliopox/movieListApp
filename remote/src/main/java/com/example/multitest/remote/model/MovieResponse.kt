package com.example.multitest.remote.model

import com.example.multitest.remote.Constant
import com.google.gson.annotations.SerializedName
import java.util.Date

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val posterImagePath: String,
    @SerializedName("backdrop_path")
    val backdropImagePath: String,
    @SerializedName("vote_average")
    val rating: Float,
    @SerializedName("vote_count")
    val rateCount: Int,
    @SerializedName("release_date")
    val releasedAt: Date,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("genres")
    val genres: List<GenreResponse>
)  {

    val posterImageUrl: String
        get() = Constant.POSTER_IMAGE_PREFIX_URL + posterImagePath

    val backdropImageUrl: String
        get() = Constant.BACKDROP_IMAGE_PREFIX_URL + backdropImagePath
}