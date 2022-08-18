package com.example.animedb.data.model

import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("canRate") val canRate : Boolean,
    @SerializedName("rating") val rating : Double,
    @SerializedName("ratingCount") val ratingCount : Int,
    @SerializedName("topRank") val topRank : Int
)
