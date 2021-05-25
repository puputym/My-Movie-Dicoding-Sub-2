package com.puput.mymoviesubdua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse
import com.puput.mymoviesubdua.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieRepository constructor(val remoteDataSource: RemoteDataSource) {

    fun getAllMovie(): LiveData<List<ListMovieResponse>> {
        val movieData = MutableLiveData<List<ListMovieResponse>>()

        CoroutineScope(IO).launch {
            remoteDataSource.getMovie(object : RemoteDataSource.movieCallback {
                override fun onAllMovieReceived(movieResponse: List<ListMovieResponse>) {
                    movieData.postValue(movieResponse)
                }

            })
        }
        return movieData

    }

    fun getAllTVShow(): LiveData<List<ListTvShowResponse>> {
        val tvData = MutableLiveData<List<ListTvShowResponse>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShow(object : RemoteDataSource.tvShowCallback {
                override fun onAllTvShowReceived(tvShowResponse: List<ListTvShowResponse>) {
                    tvData.postValue(tvShowResponse)
                }
            })
        }
        return tvData
    }

    fun getAllDetailMovie(Id: String): LiveData<DetailMovie> {
        val movieDetailData = MutableLiveData<DetailMovie>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailMovie(Id, object : RemoteDataSource.detailMovieCallback {
                override fun onDetailMovieReceive(detailMovie: DetailMovie) {
                    movieDetailData.postValue(detailMovie)
                }
            })
        }
        return movieDetailData
    }

    fun getAllDetailTvShow(Id: String): LiveData<DetailTVShow> {
        val tvShowDetailData = MutableLiveData<DetailTVShow>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailTvShow(Id, object : RemoteDataSource.detailTvShowCallback {
                override fun onDetailTvShowReceived(detailTvShow: DetailTVShow) {
                    tvShowDetailData.postValue(detailTvShow)
                }
            })
        }
        return tvShowDetailData
    }


}
