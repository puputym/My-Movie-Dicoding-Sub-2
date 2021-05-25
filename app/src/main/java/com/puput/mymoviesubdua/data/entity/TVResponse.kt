package com.puput.mymoviesubdua.data.entity

import com.google.gson.annotations.SerializedName

data class TVResponse (
    @SerializedName("results")
    val results: List<ListTvShowResponse>,

)