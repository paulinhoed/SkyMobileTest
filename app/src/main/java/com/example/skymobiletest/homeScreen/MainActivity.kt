package com.example.skymobiletest.homeScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skymobiletest.R
import com.example.skymobiletest.transact


class MainActivity : AppCompatActivity(),HomeFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        showFragment(HomeFragment())
    }

    private fun showFragment(fragment: Fragment) {
        transact {
            replace(R.id.container, fragment)
        }
    }

    override fun startDetailMovieFragment(fragment: Fragment) {
        showFragment(fragment)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
