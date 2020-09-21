package com.example.skymobiletest.homeScreen

import android.util.Log
import java.lang.ref.WeakReference
import java.util.*

interface HomePresenterInput {
    fun presentHomeData(response: HomeResponse)
}

class HomePresenter : HomePresenterInput {

    var output: WeakReference<HomeFragmentInput>? = null

    override fun presentHomeData(response: HomeResponse) {
        Log.d(TAG, "presentHomeData() called with: response = [$response]")
        // Do your decoration or filtering here
        val homeViewModel = HomeViewModel()
        homeViewModel.listOfMovies = ArrayList()

        if (response.listOfMovies != null) {

            for (movieModel in response.listOfMovies!!) {
                val movieViewModel = MovieViewModel(backdrops_url = null,
                    id = movieModel.id,
                    title = movieModel.title,
                    overview = movieModel.overview,
                    duration = movieModel.duration,
                    release_year = movieModel.release_year,
                    cover_url = movieModel.cover_url
                )
                homeViewModel.listOfMovies?.add(movieViewModel)
            }
            output?.get()?.displayHomeData(homeViewModel)
        }
    }

    companion object {
        const val TAG = "HomePresenter"
    }
}
