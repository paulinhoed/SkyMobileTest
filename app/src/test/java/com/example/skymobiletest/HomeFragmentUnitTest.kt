package com.example.skymobiletest

import com.example.skymobiletest.homeScreen.HomeFragment
import com.example.skymobiletest.homeScreen.HomeInteractorInput
import com.example.skymobiletest.homeScreen.HomeRequest
import com.example.skymobiletest.homeScreen.MainActivity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class HomeFragmentUnitTest {

    @Test
    fun mainActivity_ShouldNOT_be_Null() {
        // Given
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        // When

        // Then
        Assert.assertNotNull(activity)
    }

    @Test
    fun fragment_ShouldNOT_be_Null() {
        // Given
        val fragment = HomeFragment()
        // When

        // Then
        Assert.assertNotNull(fragment)
    }

    @Test
    fun onCreateView_shouldCall_fetchHomeData() {
        // Given
        val fragmentOutputSpy = HomeFragmentOutputSpy()

        // It must have called the onCreateView earlier,
        // we are injecting the mock and calling the fetchData to test our condition
        val homeFragment = HomeFragment()
        homeFragment.output = fragmentOutputSpy

        // When
        homeFragment.fetchData()

        // Then
        Assert.assertTrue(fragmentOutputSpy.fetchHomeDataIsCalled)
    }

    @Test
    fun onCreateView_Calls_fetchHomeData_withCorrectData() {
        // Given
        val fragmentOutputSpy = HomeFragmentOutputSpy()
        val homeFragment = HomeFragment()
        homeFragment.output = fragmentOutputSpy

        // When
        homeFragment.fetchData()

        // Then
        Assert.assertNotNull(homeFragment)
        Assert.assertNotNull(fragmentOutputSpy.homeRequestCopy)
    }

    private inner class HomeFragmentOutputSpy : HomeInteractorInput {

        var fetchHomeDataIsCalled = false
        lateinit var homeRequestCopy: HomeRequest

        override fun fetchHomeData(request: HomeRequest) {
            fetchHomeDataIsCalled = true
            homeRequestCopy = request
        }

        override fun fetchFakeHomeData(request: HomeRequest) {
            fetchHomeDataIsCalled = true
            homeRequestCopy = request
        }
    }
}
