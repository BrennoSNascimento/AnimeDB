package com.example.animedb.data.model

import com.google.gson.annotations.SerializedName

data class Certificates(
    @SerializedName("US") val uS : List<US>
)
