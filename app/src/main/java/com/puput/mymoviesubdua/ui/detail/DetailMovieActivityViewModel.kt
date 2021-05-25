package com.puput.mymoviesubdua.ui.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puput.mymoviesubdua.data.MovieRepository
import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow


class DetailMovieActivityViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getDetailMovie(idMovie: String): LiveData<DetailMovie> =
        movieRepository.getAllDetailMovie(idMovie)

    fun getDetailTvShow(idTv: String): LiveData<DetailTVShow> =
        movieRepository.getAllDetailTvShow(idTv)


}