package com.daniel.data.network

import com.daniel.data.dto.DTOMoviesList
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int,
        @Query("language") language: String
    ): DTOMoviesList
}