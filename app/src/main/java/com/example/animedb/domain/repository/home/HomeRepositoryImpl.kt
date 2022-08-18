package com.example.animedb.domain.repository.home


import com.example.animedb.data.api.HomeApi
import com.example.animedb.data.model.MovieDetail
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeApi: HomeApi) : HomeRepository {

    override fun getMovies() : Single<List<String>> =
        homeApi.getMovies()

    override fun getMoviesById(tconst : String) : Single<MovieDetail> =
        homeApi.getMoviesById(tconst)
}