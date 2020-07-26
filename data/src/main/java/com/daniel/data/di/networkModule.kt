package com.daniel.data.di

import com.daniel.data.network.MoviesService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "b3a4b5d81d7ea4b3c2ed0a3637fb35ab"
private const val KEY_API = "api_key"

val networkModule = module {
    factory {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request().newBuilder()
                        val originalHttpUrl = chain.request().url()
                        val url = originalHttpUrl.newBuilder().addQueryParameter(KEY_API, API_KEY).build()
                        request.url(url)
                        return@addInterceptor chain.proceed(request.build())
                    }
                    .build()
            )
            .build()
    }
    single {
        get<Retrofit>().create(MoviesService::class.java)
    }
}