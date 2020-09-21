package com.example.skymobiletest.api

import com.example.skymobiletest.homeScreen.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoints {
    @GET("Movies")
    fun getMoviesList(): Call<List<MovieModel>>
}