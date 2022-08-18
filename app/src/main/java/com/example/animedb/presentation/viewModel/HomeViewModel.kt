package com.example.animedb.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animedb.base.BaseViewModel
import com.example.animedb.data.model.MovieDetail
import com.example.animedb.domain.Results
import com.example.animedb.domain.useCase.home.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    private val _movies = MutableLiveData<List<String>>()
    val movies : LiveData<List<String>> = _movies

    val movieDetailList : MutableList<MovieDetail> = arrayListOf()

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail> = _movieDetail


    var n : Int = 0

    var isLoading = MutableLiveData<Boolean>().apply{value= false}
    var isFinish = MutableLiveData<Boolean>().apply{value= false}

    fun executeGetMovies(){
        homeUseCase.executeGetMovies()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe{handleGetMoviesResult(it)}
            ?.addTo(disposable)
    }

    private fun handleGetMoviesResult(result : Results.MovieResult){
        when(result){
            is Results.MovieResult.Success ->{
                _movies.postValue(result.movieData)

            }
            is Results.MovieResult.Failure ->{
                isLoading.value= false
            }
            is Results.MovieResult.Loading -> {

            }
        }
    }

    fun t(tconst:String){
        Thread.sleep(500)
        executeGetMoviesById(tconst)
    }

     fun executeGetMoviesById(
         tconst:String
    ){
        homeUseCase.executeGetMoviesById(tconst)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe{handleExecuteGetMoviesByIdResult(it)}
            ?.addTo(disposable)
    }

    private fun handleExecuteGetMoviesByIdResult(result : Results.MovieDetailResult){
        when(result){
            is Results.MovieDetailResult.Success ->{
                _movieDetail.postValue(result.movieDetail)
                movieDetailList.add(result.movieDetail)
                n++
                if (n == 19){
                    isFinish.value = true
                }

            }
            is Results.MovieDetailResult.Failure ->{
                isLoading.value= false
            }
            is Results.MovieDetailResult.Loading -> {

            }
        }
    }

}