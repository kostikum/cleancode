package com.kostikum.cleancode.presentation.test.mvp

class TestPresenterDefault(private val view: TestView) : TestPresenter {

    private val helloText: String

    init {
        helloText = "Hello"

    }

    override fun onReloadData() {
        view.showHelloText(helloText)
    }

    override fun onHelloClick() {

    }
}
