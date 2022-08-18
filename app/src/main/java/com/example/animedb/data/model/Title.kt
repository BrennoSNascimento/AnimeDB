package com.example.animedb.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Title(
    @SerializedName("@type") val type : String,
    @SerializedName("disambiguation") val disambiguation : String,
    @SerializedName("id") val id : String,
    @SerializedName("image") val image : Image,
    @SerializedName("runningTimeInMinutes") val runningTimeInMinutes : Int,
    @SerializedName("title") val title : String,
    @SerializedName("titleType") val titleType : String,
    @SerializedName("year") val year : Int
):Serializable
