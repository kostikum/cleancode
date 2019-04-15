package com.kostikum.cleancode.data.repository.vehicle

import com.kostikum.cleancode.data.entity.vehicle.transform
import com.kostikum.cleancode.data.net.provideApi
import com.kostikum.cleancode.domain.entity.vehicle.CoordinateParam
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import com.kostikum.cleancode.domain.repository.vehicle.VehicleRepository
import io.reactivex.Single

class VehicleRepositoryRemote(private val url: String) : VehicleRepository {

    private val api = provideApi()

    override fun fetch(param: CoordinateParam): Single<List<Vehicle>> {

        return api.getVehicle(
            param.lat1,
            param.lon1,
            param.lat2,
            param.lon2
        )
            .map {vehiclePoiList ->
                vehiclePoiList.poiList.map {
                        vehicleResponse ->  vehicleResponse.transform()
                }
            }

    }
}
