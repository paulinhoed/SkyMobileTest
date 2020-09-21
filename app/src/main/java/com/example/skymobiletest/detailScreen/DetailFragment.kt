package com.example.skymobiletest.detailScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.skymobiletest.R
import com.example.skymobiletest.homeScreen.MovieModel

class DetailFragment : Fragment() {

    private var movieModel: MovieModel? = null

    private var title: TextView? = null
    private var releaseYear: TextView? = null
    private var overview: TextView? = null
    private var duration: TextView? = null
    private var thumbnail: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        movieModel = this.arguments?.getParcelable("movie")
        bindViews(view)
        displayMovieDetails(movieModel)

        return view
    }

    private fun bindViews(view: View) {
        title = view.findViewById(R.id.tvTitle)
        releaseYear = view.findViewById(R.id.tvReleaseYear)
        overview = view.findViewById(R.id.tvOverView)
        duration = view.findViewById(R.id.tvDuration)
        thumbnail = view.findViewById(R.id.ivMovie)
    }

    private fun displayMovieDetails(movieModel: MovieModel?) {
        Log.e(TAG, "displayMovieData() called with: viewModel = [$movieModel]")
        title?.text = movieModel?.title
        overview?.text = movieModel?.overview
        releaseYear?.text = movieModel?.release_year
        duration?.text = movieModel?.duration
        Glide.with(this)
            .load(movieModel!!.cover_url)
            .placeholder(R.drawable.ic_baseline_photo_24)
            .into(thumbnail!!)
    }

    companion object {
        const val TAG = "DetailFragment"
    }
}