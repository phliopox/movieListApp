package com.example.multitest.mm.domain.model

data class SummaryActor(
    val id : Int,
    val name : String,
    val character : String,
    val popularity : Float,
    val profileImageUrl : String?,
    val profileDetailUrl : String
)
