package com.kostikum.cleancode.presentation.screen.vehicle.list

import android.arch.lifecycle.MutableLiveData
import com.kostikum.cleancode.domain.entity.AppException
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import com.kostikum.cleancode.domain.usecase.vehicle.GetVehicleUseCase
import com.kostikum.cleancode.presentation.base.BaseViewModel
import io.reactivex.subjects.PublishSubject

class VehicleListViewModel(vehicleUseCase: GetVehicleUseCase) : BaseViewModel() {

    val vehicleState = MutableLiveData<VehicleState>()

    val vehicleClicked = MutableLiveData<Vehicle>()

    init {

        vehicleState.value = VehicleState.Progress

        val disposable = vehicleUseCase
            .get()
            .subscribe({
                vehicleState.value = VehicleState.Done(it)
            }, {
                if (it is AppException) {
                    it.type
                } else {

                }

                vehicleState.value = VehicleState.Error(it)
            })
        disposables.add(disposable)
    }

    fun vehicleClick(vehicle: Vehicle) {
        vehicleClicked.value = vehicle
    }

}
