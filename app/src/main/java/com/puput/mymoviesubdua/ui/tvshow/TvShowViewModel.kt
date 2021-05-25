package com.puput.mymoviesubdua.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puput.mymoviesubdua.data.MovieRepository
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse


class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getAllTvShow(): LiveData<List<ListTvShowResponse>> = movieRepository.getAllTVShow()


}