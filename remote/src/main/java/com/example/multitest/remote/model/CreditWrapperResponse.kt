package com.example.multitest.remote.model

import com.google.gson.annotations.SerializedName

data class CreditWrapperResponse (
    @SerializedName("cast")
    val cast : List<CreditResponse>
)