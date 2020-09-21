package com.example.skymobiletest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://sky-exercise.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun movieService() = retrofit.create(ApiEndPoints::class.java)
}