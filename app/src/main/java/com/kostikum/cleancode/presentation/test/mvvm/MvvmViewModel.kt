package com.kostikum.cleancode.presentation.test.mvvm

interface MvvmViewModel {
    fun setHelloTextListener(listener: HelloTextListener)
    fun helloClick()
    fun reloadData()
}