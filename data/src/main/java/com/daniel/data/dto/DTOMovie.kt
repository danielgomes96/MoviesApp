package com.daniel.data.dto

import com.google.gson.annotations.SerializedName

data class DTOMovie(
    @SerializedName("id")
    val id: Double,
    @SerializedName("original_language")
    val originalTitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val imageUrl: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("popularity")
    val popularity: Float
)