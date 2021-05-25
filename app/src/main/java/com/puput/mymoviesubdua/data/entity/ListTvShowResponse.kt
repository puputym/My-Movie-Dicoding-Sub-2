package com.puput.mymoviesubdua.data.entity

import com.google.gson.annotations.SerializedName

data class ListTvShowResponse(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("first_air_date")
        val firstAirDate: String,

        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:SerializedName("vote_average")
        val voteAverage: Double,

        @field:SerializedName("status")
        val status: String

)