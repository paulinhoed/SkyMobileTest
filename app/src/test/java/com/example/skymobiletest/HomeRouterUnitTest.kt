package com.example.skymobiletest

import com.example.skymobiletest.detailScreen.DetailFragment
import com.example.skymobiletest.homeScreen.HomeRouter
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeRouterUnitTest {

    @Test
    fun homeRouter_determineNextScreen() {
        //Given
        val homeRouter = HomeRouter()

        // When - Future Trip is Input
        val fragment = homeRouter.determineNextScreen(0)

        // Then
        val targetFragmentName = fragment.javaClass.name
        Assert.assertEquals(
            "When the future travel date is passed to HomeRouter"
                    + " Then next Intent should be BoardingActivity",
            targetFragmentName,
            DetailFragment::class.java.getName()
        )
    }

    companion object {
        const val TAG = "HomeRouterUnitTest"
    }
}
