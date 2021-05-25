package com.puput.mymoviesubdua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse
import com.puput.mymoviesubdua.data.remote.MovieDataSource
import com.puput.mymoviesubdua.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    override fun getAllMovie(): LiveData<List<ListMovieResponse>> {
        val movieData = MutableLiveData<List<ListMovieResponse>>()

        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovie(object : RemoteDataSource.movieCallback {
                override fun onAllMovieReceived(movieResponse: List<ListMovieResponse>) {
                    movieData.postValue(movieResponse)
                }

            })
        }
        return movieData

    }

    override fun getAllTvShow(): LiveData<List<ListTvShowResponse>> {
        val tvData = MutableLiveData<List<ListTvShowResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShow(object : RemoteDataSource.tvShowCallback {
                override fun onAllTvShowReceived(tvShowResponse: List<ListTvShowResponse>) {
                    tvData.postValue(tvShowResponse)
                }
            })
        }
        return tvData
    }

    override fun getDetailMovie(Id: String): LiveData<DetailMovie> {
        val movieDetailData = MutableLiveData<DetailMovie>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDetailMovie(Id, object : RemoteDataSource.detailMovieCallback {
                override fun onDetailMovieReceive(detailMovie: DetailMovie) {
                    movieDetailData.postValue(detailMovie)
                }
            })
        }
        return movieDetailData
    }

    override fun getDetailTvShow(Id: String): LiveData<DetailTVShow> {
        val tvShowDetailData = MutableLiveData<DetailTVShow>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDetailTvShow(Id, object : RemoteDataSource.detailTvShowCallback {
                override fun onDetailTvShowReceived(detailTvShow: DetailTVShow) {
                    tvShowDetailData.postValue(detailTvShow)
                }
            })
        }
        return tvShowDetailData
    }

}