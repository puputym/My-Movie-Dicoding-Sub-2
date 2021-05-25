package com.puput.mymoviesubdua.data.entity

import com.google.gson.annotations.SerializedName

data class DetailMovie(


    @SerializedName("overview")
    val overview: String = "",

    @SerializedName("poster_path")
    val posterPath: String ="",

    @SerializedName("release_date")
    val releaseDate: String = "",

    @SerializedName("title")
    val title: String = "",

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("runtime")
    val runtime: String,

    @SerializedName("id")
    val id: Int = 0,

    )
