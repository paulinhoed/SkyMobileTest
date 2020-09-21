package com.example.skymobiletest.homeScreen

import android.util.Log
import com.example.skymobiletest.ArrayEmptyException
import com.example.skymobiletest.api.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface HomeInteractorInput {
    fun fetchHomeData(request: HomeRequest)
    fun fetchFakeHomeData(request: HomeRequest)
}

class HomeInteractor : HomeInteractorInput {

    var output: HomePresenterInput? = null

    var workerInput: MovieWorkerInput? = null
        get() {
            return field ?: MovieWorker()
        }

    override fun fetchHomeData(request: HomeRequest) {
        val call = RetrofitInitializer().movieService().getMoviesList()
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                response?.body()?.let {
                    val movies: ArrayList<MovieModel> = it as ArrayList<MovieModel>
                    val homeResponse = HomeResponse()
                    homeResponse.listOfMovies = movies
                    output?.presentHomeData(homeResponse)
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    override fun fetchFakeHomeData(request: HomeRequest) {
        Log.d(TAG, "In method fetchHomeData")
        val response = HomeResponse()

        response.listOfMovies = workerInput?.movies

        if (null == response.listOfMovies || response.listOfMovies!!.isEmpty()) {
            throw ArrayEmptyException("Empty Movie List")
        }

        output?.presentHomeData(response)
    }

    companion object {
        const val TAG = "HomeInteractor"
    }
}
