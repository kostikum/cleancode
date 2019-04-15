package com.kostikum.cleancode.data.entity.vehicle

import com.kostikum.cleancode.domain.entity.vehicle.FleetType
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle

private const val FLEET_TYPE_POOLING = "POOLING"
private const val FLEET_TYPE_TAXI = "TAXI"

internal fun VehicleResponse.transform() : Vehicle {


    return Vehicle(id = id,
        lat = coordinate.latitude,
        lon = coordinate.longitude,
        fleetType = transformFleetType(fleetType),
        heading = heading)
}


private fun transformFleetType(fleetType: String) : FleetType {

    return when(fleetType) {
        FLEET_TYPE_TAXI -> FleetType.TAXI
        FLEET_TYPE_POOLING -> FleetType.POOLING
        else -> FleetType.UNDEFINED
    }
}
