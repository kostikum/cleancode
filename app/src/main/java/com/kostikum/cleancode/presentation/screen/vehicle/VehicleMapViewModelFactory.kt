package com.kostikum.cleancode.presentation.screen.vehicle

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kostikum.cleancode.app.UseCaseProvider

class VehicleMapViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return VehicleMapViewModel(UseCaseProvider.provideGetVehicleUseCase(true)) as T
    }

}
