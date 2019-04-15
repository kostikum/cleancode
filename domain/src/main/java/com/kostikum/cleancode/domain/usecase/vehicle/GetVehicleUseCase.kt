package com.kostikum.cleancode.domain.usecase.vehicle

import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface GetVehicleUseCase {
    fun get() : Single<List<Vehicle>>
}
