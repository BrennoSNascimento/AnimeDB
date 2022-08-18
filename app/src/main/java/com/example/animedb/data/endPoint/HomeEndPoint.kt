package com.example.animedb.data.endPoint

import com.example.animedb.data.model.MovieDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeEndPoint {
    @GET("title/get-most-popular-movies")
    fun getMovies() : Single<List<String>>

    @GET("title/get-overview-details")
    fun getMovieById(
        @Query("tconst") tconst : String,
    ) : Single<MovieDetail>
}