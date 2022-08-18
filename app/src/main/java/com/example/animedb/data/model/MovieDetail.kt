package com.example.animedb.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDetail(
    @SerializedName("id") val id : String,
    @SerializedName("title") val title : Title,
    @SerializedName("ratings") val ratings : Ratings,
    @SerializedName("genres") val genres : List<String>,
    @SerializedName("releaseDate") val releaseDate : String,
    @SerializedName("plotOutline") val plotOutline : PlotOutline
): Serializable
