package com.puput.mymoviesubdua.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceAPI {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    val retrofit: ServiceAPI =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ServiceAPI::class.java)


}