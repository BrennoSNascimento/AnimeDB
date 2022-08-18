package com.example.animedb.data.model

import com.google.gson.annotations.SerializedName

data class US(
    @SerializedName("attributes") val attributes : List<String>,
    @SerializedName("certificate") val certificate : String,
    @SerializedName("ratingReason") val ratingReason : String,
    @SerializedName("ratingsBody") val ratingsBody : String,
    @SerializedName("country") val country : String
)
