package com.kostikum.cleancode.presentation.screen.vehicle.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kostikum.cleancode.app.UseCaseProvider

class VehicleListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return VehicleListViewModel(UseCaseProvider.provideGetVehicleUseCase()) as T
    }

}
