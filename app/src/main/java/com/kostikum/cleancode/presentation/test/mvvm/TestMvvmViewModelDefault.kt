package com.kostikum.cleancode.presentation.test.mvvm

class TestMvvmViewModelDefault : MvvmViewModel {

    private var helloText: String = ""
    private var listener: HelloTextListener? = null

    override fun setHelloTextListener(listener: HelloTextListener) {
        this.listener = listener
    }

    override fun helloClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reloadData() {
        helloText = "Hello from Mvvm"
        listener?.onUpdated(helloText)
    }
}
