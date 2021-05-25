package com.puput.mymoviesubdua.data.api

import com.puput.mymoviesubdua.data.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceAPI {
    @GET("movie/now_playing?api_key=a55b0f0d66cce423d515d62cbf6fb9f4 ")
    fun getMovie(): Call<MovieResponse>

    @GET("tv/popular?api_key=a55b0f0d66cce423d515d62cbf6fb9f4 ")
    fun getTvShow(): Call<TVResponse>

    @GET("tv/{tv_id}?api_key=a55b0f0d66cce423d515d62cbf6fb9f4 ")
    fun getDetailTvShow(@Path("tv_id") id: String): Call<DetailTVShow>

    @GET("movie/{movie_id}?api_key=a55b0f0d66cce423d515d62cbf6fb9f4 ")
    fun getDetailMovie(@Path("movie_id") id: String): Call<DetailMovie>

}