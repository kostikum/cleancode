package com.kostikum.cleancode.domain.repository.vehicle

import com.kostikum.cleancode.domain.entity.vehicle.CoordinateParam
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface VehicleRepository {

    fun fetch(param: CoordinateParam) : Single<List<Vehicle>>

//    fun save(vehicle: Vehicle) : Boolean

}