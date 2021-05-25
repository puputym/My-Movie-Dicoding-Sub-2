package com.puput.mymoviesubdua.ui.movie


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puput.mymoviesubdua.data.MovieRepository
import com.puput.mymoviesubdua.data.entity.ListMovieResponse

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovie(): LiveData<List<ListMovieResponse>> = movieRepository.getAllMovie()
}