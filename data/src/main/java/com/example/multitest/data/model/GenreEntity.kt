package com.example.multitest.data.model

import com.example.multitest.data.DataMapper
import com.example.multitest.mm.domain.model.Genre

data class GenreEntity(
    val id : Int,
    val name : String
) : DataMapper<Genre> {
    override fun toDomain() : Genre = Genre(id, name)
}