package com.example.multitest.mm.domain.model

import java.util.Date

data class SummaryMovie(
    val id : Int,
    val name : String,
    val description : String,
    val posterImageUrl : String,
    val rating : Float ,
    val rateCount :Int,
    val releaseAt : Date
)
