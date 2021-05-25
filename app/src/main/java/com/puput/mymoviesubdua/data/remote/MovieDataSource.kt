package com.puput.mymoviesubdua.data.remote

import androidx.lifecycle.LiveData
import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse

interface MovieDataSource {
    fun getAllMovie(): LiveData<List<ListMovieResponse>>?

    fun getAllTvShow(): LiveData<List<ListTvShowResponse>>?

    fun getDetailMovie(movieId: String): LiveData<DetailMovie>?

    fun getDetailTvShow(tvId: String): LiveData<DetailTVShow>?
}