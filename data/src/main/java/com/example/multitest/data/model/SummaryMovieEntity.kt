package com.example.multitest.data.model

import com.example.multitest.data.DataMapper
import com.example.multitest.mm.domain.model.SummaryMovie
import java.util.Date

data class SummaryMovieEntity(
    val id: Int,
    val name: String,
    val description: String,
    val posterImageUrl: String,
    val rating: Float,
    val rateCount: Int,
    val releaseAt: Date
) : DataMapper<SummaryMovie> {
    override fun toDomain(): SummaryMovie =
        SummaryMovie(id, name, description, posterImageUrl, rating, rateCount, releaseAt)
}
