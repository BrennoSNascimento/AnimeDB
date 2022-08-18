package com.example.animedb.domain.repository.home

import com.example.animedb.data.model.MovieDetail
import io.reactivex.Single

interface HomeRepository {
    fun getMovies() : Single<List<String>>
    fun getMoviesById(tconst : String) :Single<MovieDetail>
}