package com.daniel.data.dto

import com.google.gson.annotations.SerializedName

data class DTOMoviesList(
    @SerializedName("results")
    val moviesList: List<DTOMovie>,
    val page: Int
)