package com.example.skymobiletest.homeScreen

import java.lang.ref.WeakReference

object HomeConfigurator {

    fun configureFragment(fragment: HomeFragment) {

        val router = HomeRouter()
        router.fragment = WeakReference(fragment)

        val presenter = HomePresenter()
        presenter.output = WeakReference(fragment)

        val interactor = HomeInteractor()
        interactor.output = presenter

        fragment.output = interactor
        fragment.router = router
    }
}
