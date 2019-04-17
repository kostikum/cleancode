package com.kostikum.cleancode.app

import com.kostikum.cleancode.data.repository.vehicle.VehicleRepositoryRemote
import com.kostikum.cleancode.domain.usecase.vehicle.GetVehicleUseCase
import com.kostikum.cleancode.domain.usecase.vehicle.GetVehicleUseCaseDefault
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UseCaseProvider {

    fun provideGetVehicleUseCase(needServerUpdate: Boolean): GetVehicleUseCase {

        return GetVehicleUseCaseDefault(
            getWorkScheduler(),
            getUiScheduler(),
            VehicleRepositoryRemote(VehicleApplication.instance.applicationContext, needServerUpdate)
        )
    }

    private fun getWorkScheduler() = Schedulers.io()

    private fun getUiScheduler() = AndroidSchedulers.mainThread()

}
