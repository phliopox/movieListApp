package com.example.multitest.data.model

import com.example.multitest.data.DataMapper
import com.example.multitest.mm.domain.model.SummaryActor

data class SummaryActorEntity(
    val id: Int,
    val name: String,
    val character: String,
    val popularity: Float,
    val profileImageUrl: String?,
    val profileDetailUrl: String
) : DataMapper<SummaryActor> {
    override fun toDomain(): SummaryActor =
        SummaryActor(id, name, character, popularity, profileImageUrl, profileDetailUrl)
}
