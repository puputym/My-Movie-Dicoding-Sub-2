package com.puput.mymoviesubdua.data.entity

import com.google.gson.annotations.SerializedName

data class DetailTVShow(

        @SerializedName("first_air_date")
        val firstAirDate: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("name")
        val name: String = "",
        @SerializedName("overview")
        val overview: String = "",
        @field:SerializedName("vote_average")
        val voteAverage: Double,
        @SerializedName("poster_path")
        val posterPath: String = "",
        @field:SerializedName("status")
        val status: String

)
