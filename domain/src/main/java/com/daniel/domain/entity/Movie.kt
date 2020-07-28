package com.daniel.domain.entity

import java.io.Serializable
import java.util.*

data class Movie(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val voteAverage: Float,
    val isAdult: Boolean,
    val releaseDate: Date
) : Serializable