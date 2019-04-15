package com.kostikum.cleancode.presentation.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseMvvmActivity<VM: BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VM

    @LayoutRes
    protected abstract fun provideLayoutId() : Int
    protected abstract fun provideViewModel() : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = provideViewModel()

        setContentView(provideLayoutId())
    }
}
