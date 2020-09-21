package com.example.skymobiletest.homeScreen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.skymobiletest.detailScreen.DetailFragment
import java.lang.ref.WeakReference

interface HomeRouterInput {
    fun determineNextScreen(position: Int): Fragment
    fun passDataToNextScene(position: Int, nextFragment: Fragment)
}

class HomeRouter : HomeRouterInput, AdapterView.OnItemClickListener {

    var fragment: WeakReference<HomeFragment>? = null

    override fun determineNextScreen(position: Int): Fragment {
        return DetailFragment()
    }

    override fun passDataToNextScene(position: Int, nextFragment: Fragment) {
        // Based on the position or some other data decide the data for the next scene
        val movie = fragment?.get()?.listOfVMMovies?.get(position)
        val args =  Bundle()
        args.putParcelable("movie",movie)
        nextFragment.arguments = args
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        Log.d(TAG, "onItemClick() called with: parent = [$parent], view = [$view], position = [$position], id = [$id]");
        val nextFragment = determineNextScreen(position)
        passDataToNextScene(position, nextFragment)
        fragment?.get()?.homeFragmentListener?.startDetailMovieFragment(nextFragment)
    }

    companion object {
        const val TAG = "HomeRouter"
    }
}
