package com.example.animedb.data.model

import com.google.gson.annotations.SerializedName

data class PlotOutline(
    @SerializedName("id") val id : String,
    @SerializedName("text") val text : String
)
