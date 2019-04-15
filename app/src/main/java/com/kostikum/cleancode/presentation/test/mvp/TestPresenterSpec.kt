package com.kostikum.cleancode.presentation.test.mvp

class TestPresenterSpec(private val view: TestView) : TestPresenter {

    private val helloText: String

    init {
        helloText = "Goodbuy"

    }

    override fun onReloadData() {
        view.showHelloText(helloText)
    }

    override fun onHelloClick() {

    }
}
