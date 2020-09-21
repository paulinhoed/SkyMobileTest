package com.example.skymobiletest

import com.example.skymobiletest.homeScreen.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.lang.ref.WeakReference


@RunWith(RobolectricTestRunner::class)
class HomePresenterUnitTest {

    @Test
    fun presentHomeData_with_validInput_shouldCall_displayHomeData() {
        // Given
        val homePresenter = HomePresenter()
        val homeResponse = HomeResponse()

        val moviesList = ArrayList<MovieModel>()

        val movie1 = MovieModel(
            id = "090f0d8fs9d0dfdf",
            title = "Doutor Estranho",
            overview = "Stephen Strange (Benedict Cumberbatch) leva uma vida bem sucedida como neurocirurgião. Sua vida muda completamente quando sofre um acidente de carro e fica com as mãos debilitadas. Devido a falhas da medicina tradicional, ele parte para um lugar inesperado em busca de cura e esperança, um misterioso enclave chamado Kamar-Taj, localizado em Katmandu. Lá descobre que o local não é apenas um centro medicinal, mas também a linha de frente contra forças malignas místicas que desejam destruir nossa realidade. Ele passa a treinar e adquire poderes mágicos, mas precisa decidir se vai voltar para sua vida comum ou defender o mundo.",
            duration = "1h 55m",
            release_year = "2017",
            cover_url = "https://image.tmdb.org/t/p/w1280/dsAQmTOCyMDgmiPp9J4aZTvvOJP.jpg"
        )
        moviesList.add(movie1)
        homeResponse.listOfMovies = moviesList

        val homeFragmentInputSpy = HomeFragmentInputSpy()
        homePresenter.output = WeakReference(homeFragmentInputSpy)

        // When
        homePresenter.presentHomeData(homeResponse)

        // Then
        Assert.assertTrue("When the valid input is passed to HomePresenter " +
                "Then displayHomeData should be called",
            homeFragmentInputSpy.isDisplayHomeDataCalled)
    }

    @Test
    fun presentHomeData_with_inValidInput_shouldNotCall_displayHomeData() {
        // Given
        val homePresenter = HomePresenter()
        val homeResponse = HomeResponse()
        homeResponse.listOfMovies = null

        val homeFragmentInputSpy = HomeFragmentInputSpy()
        homePresenter.output = WeakReference(homeFragmentInputSpy)

        // When
        homePresenter.presentHomeData(homeResponse)

        // Then
        Assert.assertFalse("When the valid input is passed to HomePresenter " +
                "Then displayHomeData should NOT be called",
            homeFragmentInputSpy.isDisplayHomeDataCalled)
    }

//    @Test
//    fun verify_HomePresenter_getDaysDiff_is_CalculatedCorrectly_ForFutureTrips() {
//        // Given
//        val homePresenter = HomePresenter()
//        val homeResponse = HomeResponse()
//
//        val moviesList = ArrayList<MovieModel>()
//
//        val movie1 = MovieModel(
//            movieName = "9Z 231",
//            startingTime = "2017/12/31",
//            departureCity = "BLR",
//            arrivalCity = "CJB",
//            departureTime = "18:10",
//            arrivalTime = "19:00"
//        )
//        moviesList.add(movie1)
//        homeResponse.listOfMovies = moviesList
//
//        val homeActivityInputSpy = HomeFragmentInputSpy()
//        homePresenter.output = WeakReference(homeActivityInputSpy)
//
//        // When
//        val currentTime = Calendar.getInstance()
//        currentTime.set(2017, 5, 30, 0, 0, 0)
//        homePresenter.currentTime = currentTime
//        homePresenter.presentHomeData(homeResponse)
//
//        // Then
//        // "It has been " + daysDiff + " days since you flew";
//        val expectedText = "You have " + "184" + " days to fly"
//        val actualText = homeActivityInputSpy.homeViewModelCopy.listOfMovies?.get(0)?.noOfDaysToFly
//        Assert.assertEquals("When current date is 2016/10/12 & " +
//                "Flying Date is 2016/10/31 Then no of days should be 19", expectedText, actualText)
//    }
//
//    @Test
//    fun verify_HomePresenter_getDaysDiff_isCalculatedCorrectly_ForPastTrips() {
//        // Given
//        val homePresenter = HomePresenter()
//        val homeResponse = HomeResponse()
//
//        val moviesList = ArrayList<MovieModel>()
//
//        val movie1 = MovieModel(
//            movieName = "9Z 231",
//            startingTime = "2016/10/01",
//            departureCity = "BLR",
//            arrivalCity = "CJB",
//            departureTime = "18:10",
//            arrivalTime = "19:00"
//        )
//
//        moviesList.add(movie1)
//
//        homeResponse.listOfMovies = moviesList
//
//        val homeFragmentInputSpy = HomeFragmentInputSpy()
//        homePresenter.output = WeakReference(homeFragmentInputSpy)
//
//        // When
//        val currentTime = Calendar.getInstance()
//        // currentTime.set(2017,5,30,0,0,0);
//        currentTime.set(2017, 5, 30)
//        Log.d(TAG, "verify_HomePresenter_getDaysDiff_isCalculatedCorrectly_ForPastTrips: "
//                + currentTime.toString())
//        homePresenter.currentTime = currentTime
//        homePresenter.presentHomeData(homeResponse)
//
//        // Then
//        // "It has been " + daysDiff + " days since you flew";
//        val expectedText = "It has been " + 272 + " days since you flew"
//        val actualText = homeFragmentInputSpy.homeViewModelCopy.listOfMovies?.get(0)?.noOfDaysToFly
//        Assert.assertEquals("When current date is 2017/05/30 & " +
//                "Flying Date is 2016/10/01 Then no of days should be 271", expectedText, actualText)
//    }

    private inner class HomeFragmentInputSpy : HomeFragmentInput {
        var isDisplayHomeDataCalled = false
        lateinit var homeViewModelCopy: HomeViewModel
        override fun displayHomeData(viewModel: HomeViewModel) {
            isDisplayHomeDataCalled = true
            homeViewModelCopy = viewModel
        }
    }

    companion object {
        const val TAG = "HomePresenterUnitTest"
    }
}
