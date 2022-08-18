package com.example.animedb.domain.useCase.home

import com.example.animedb.domain.Results
import com.example.animedb.domain.repository.home.HomeRepository
import io.reactivex.Observable
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    fun executeGetMovies(
    ): Observable<Results.MovieResult> {
        return homeRepository.getMovies()
            .toObservable()
            .map{
                Results.MovieResult.Success(it) as Results.MovieResult
            }
            .onErrorReturn{Results.MovieResult.Failure(it)}
            .startWith(Results.MovieResult.Loading)
    }

    fun executeGetMoviesById(
        tconst: String
    ): Observable<Results.MovieDetailResult> {
        return homeRepository.getMoviesById(tconst)
            .toObservable()
            .map{
                Results.MovieDetailResult.Success(it) as Results.MovieDetailResult
            }
            .onErrorReturn{Results.MovieDetailResult.Failure(it)}
            .startWith(Results.MovieDetailResult.Loading)
    }



}