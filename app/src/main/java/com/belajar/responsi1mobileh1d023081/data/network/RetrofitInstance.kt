package com.belajar.responsi1mobileh1d023081.data.network

import com.belajar.responsi1mobileh1d023081.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Auth-Token", "c7d964ee7eb4474caf4d7a375b1cde22")
                .build()
            chain.proceed(request)
        }
        .build()

    val api: FootballDataApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.API_URI)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballDataApi::class.java)
    }
}