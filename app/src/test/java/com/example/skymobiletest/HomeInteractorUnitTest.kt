package com.example.skymobiletest

import com.example.skymobiletest.homeScreen.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.*

@RunWith(RobolectricTestRunner::class)
class HomeInteractorUnitTest {

    @Test
    fun fetchHomeData_with_validInput_shouldCall_presentHomeData() {
        // Given
        val homeInteractor = HomeInteractor()
        val homeRequest = HomeRequest()
        val homePresenterInputSpy = HomePresenterInputSpy()
        homeInteractor.output = homePresenterInputSpy
        // When
        homeInteractor.fetchFakeHomeData(homeRequest)

        // Then
        Assert.assertTrue("When the valid input is passed to HomeInteractor "
                + "Then presentHomeData should be called",
            homePresenterInputSpy.presentHomeDataIsCalled)
    }

        @Test
    fun fetchHomeData_with_validInput_shouldCall_worker_getMovies() {
        // Given
        val homeInteractor = HomeInteractor()
        val homeRequest = HomeRequest()

        // Setup TestDoubles
        homeInteractor.output = HomePresenterInputSpy()
        val movieWorkerInputSpy = MovieWorkerInputSpy()
        homeInteractor.workerInput = movieWorkerInputSpy

        // When
        homeInteractor.fetchFakeHomeData(homeRequest)

        // Then
        Assert.assertTrue("When the input is passed to HomeInteractor is FutureTrip"
                + "Then getFutureMovies should be called in Worker",
            movieWorkerInputSpy.isGetMoviesMethodCalled)
    }

    @Test(expected = ArrayEmptyException::class)
    fun fetchHomeData_fetchingNull_shouldThrowArrayEmptyException() {
        // Given
        val homeInteractor = HomeInteractor()
        val homeRequest = HomeRequest()

        // Setup TestDoubles
        homeInteractor.output = HomePresenterInputSpy()
        val movieWorkerInputReturnNullSpy = MovieWorkerInputReturnNullSpy()
        homeInteractor.workerInput = movieWorkerInputReturnNullSpy

        // When
        homeInteractor.fetchFakeHomeData(homeRequest)

        // Then
        // Check for ArrayEmptyException -- See this method Annotation
    }

    private inner class HomePresenterInputSpy: HomePresenterInput {

        internal var presentHomeDataIsCalled = false
        internal var homeResponseCopy: HomeResponse? = null
        override fun presentHomeData(response: HomeResponse) {
            presentHomeDataIsCalled = true
            homeResponseCopy = response
        }
    }

    private inner class MovieWorkerInputSpy : MovieWorkerInput {
        internal var isGetMoviesMethodCalled = false

        override val movies: ArrayList<MovieModel>
            get() {
                isGetMoviesMethodCalled = true
                return movieModels
            }

        private val movieModels: ArrayList<MovieModel>
            get() {
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
                return moviesList
            }
    }

    private inner class MovieWorkerInputReturnNullSpy : MovieWorkerInput {

        internal var isGetMoviesMethodCalled = false

        override val movies: ArrayList<MovieModel> = arrayListOf()
            get() {
                isGetMoviesMethodCalled = true
                return field
            }
    }
}