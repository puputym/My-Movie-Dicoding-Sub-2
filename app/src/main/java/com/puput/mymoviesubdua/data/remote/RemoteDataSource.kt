package com.puput.mymoviesubdua.data.remote


import com.puput.mymoviesubdua.data.api.ServiceAPI
import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse
import com.puput.mymoviesubdua.utils.EspressoIdlingResource
import retrofit2.await


class RemoteDataSource(private val serviceAPI: ServiceAPI) {


    suspend fun getMovie(callback: movieCallback) {
        EspressoIdlingResource.increment()
        serviceAPI.getMovie().await().results.let {
            callback.onAllMovieReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShow(callback: tvShowCallback) {
        EspressoIdlingResource.increment()
        serviceAPI.getTvShow().await().results.let {

            callback.onAllTvShowReceived(it)
            EspressoIdlingResource.decrement()

        }
    }

    suspend fun getDetailMovie(id: String, callback: detailMovieCallback) {
        EspressoIdlingResource.increment()
        serviceAPI.getDetailMovie(id).await().let {
            callback.onDetailMovieReceive(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailTvShow(id: String, callback: detailTvShowCallback) {

        EspressoIdlingResource.increment()
        serviceAPI.getDetailTvShow(id).await().let {
            callback.onDetailTvShowReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    interface detailMovieCallback {
        fun onDetailMovieReceive(detailMovie: DetailMovie)
    }

    interface detailTvShowCallback {
        fun onDetailTvShowReceived(detailTvShow: DetailTVShow)
    }

    interface movieCallback {
        fun onAllMovieReceived(movieResponse: List<ListMovieResponse>)
    }

    interface tvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<ListTvShowResponse>)
    }
}