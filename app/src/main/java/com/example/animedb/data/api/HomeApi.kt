package com.example.animedb.data.api


import com.example.animedb.data.endPoint.HomeEndPoint
import io.reactivex.Single
import javax.inject.Inject

class HomeApi @Inject constructor(private val homeEndPoint: HomeEndPoint) {
    fun getMovies() : Single<List<String>> = homeEndPoint.getMovies()
    fun getMoviesById(tconst : String) = homeEndPoint.getMovieById(tconst)
}