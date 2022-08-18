package com.example.animedb.domain

import com.example.animedb.data.model.MovieDetail

class Results {
    sealed class MovieResult {
        object Loading : MovieResult()
        data class Success(val movieData : List<String>) : MovieResult()
        data class Failure(val throwable: Throwable) : MovieResult()
    }

    sealed class MovieDetailResult {
        object Loading : MovieDetailResult()
        data class Success(val movieDetail : MovieDetail) : MovieDetailResult()
        data class Failure(val throwable: Throwable) : MovieDetailResult()
    }
}