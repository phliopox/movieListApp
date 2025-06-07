package com.example.multitest.presentation.model

import android.os.Parcelable
import com.example.multitest.mm.domain.SummaryMovie
import java.util.Date
import kotlinx.parcelize.Parcelize

@Parcelize
data class SummaryMovieModel(
    val id: Int,
    val name: String,
    val description: String,
    val posterImageUrl: String,
    val rating: Float,
    val rateCount: Int,
    val releasedAt: Date
) : Parcelable

fun SummaryMovie.toPresentation(): SummaryMovieModel =
    SummaryMovieModel(id, name, description, posterImageUrl, rating, rateCount, releaseAt)
