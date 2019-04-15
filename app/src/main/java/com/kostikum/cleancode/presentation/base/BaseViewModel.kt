package com.kostikum.cleancode.presentation.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    private var lazyDisposable = lazy(LazyThreadSafetyMode.NONE) {
        CompositeDisposable()
    }

    protected val disposables by lazyDisposable

    override fun onCleared() {
        super.onCleared()
        if (lazyDisposable.isInitialized()) {
            disposables.dispose()
        }
    }
}
