package com.example.skymobiletest.homeScreen

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.skymobiletest.R
import java.util.*

interface HomeFragmentInput {
    fun displayHomeData(viewModel: HomeViewModel)
}

class HomeFragment : Fragment(), HomeFragmentInput {

    var listOfVMMovies: ArrayList<MovieViewModel> = arrayListOf()
    lateinit var output: HomeInteractorInput
    lateinit var router: HomeRouter
    lateinit var homeFragmentListener: HomeFragmentListener

    lateinit var listView: GridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Do the setup
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        HomeConfigurator.configureFragment(this)

        bindView(view)
        refreshList()
        return view
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            homeFragmentListener = activity as HomeFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException(requireActivity().toString() + " must implement HomeFragmentListener")
        }
    }

    fun bindView(view: View) {
        listView = view.findViewById<GridView>(R.id.listOfMovies)
    }

    fun refreshList() {
        fetchData()
        createMovieListView()
    }

    fun fetchData() {
        // create Request and set the needed input
        val request = HomeRequest()

        // Call the output to fetch the data
        output.fetchHomeData(request)

//        // Call the output to fetch fake data
//        output.fetchFakeHomeData(request)
    }

    private fun createMovieListView() {
        listView.adapter = MovieListAdapter(this.requireContext(),listOfVMMovies)
        listView.isClickable = true
        listView.onItemClickListener = router
    }

    override fun displayHomeData(viewModel: HomeViewModel) {
        Log.d(HomeFragment.TAG, "displayHomeData() called with: viewModel = [$viewModel]")
        listOfVMMovies = viewModel.listOfMovies!!
        createMovieListView()
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}

interface HomeFragmentListener{
    fun startDetailMovieFragment(fragment: Fragment)
}