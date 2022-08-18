package com.example.animedb.data.model

import java.io.Serializable

data class teste(
    val name : String,
    val genres :  List<String>,
    val duration : Int,
    val rank : Double,
    val imageWidth : Int,
    val imageUrl : String,
    val plot : String
):Serializable
