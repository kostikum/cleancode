package com.kostikum.cleancode.data.repository.vehicle

import android.content.Context
import com.kostikum.cleancode.data.db.AppDatabase
import com.kostikum.cleancode.data.entity.vehicle.transform
import com.kostikum.cleancode.data.net.provideApi
import com.kostikum.cleancode.domain.entity.vehicle.CoordinateParam
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import com.kostikum.cleancode.domain.repository.vehicle.VehicleRepository
import io.reactivex.Single

class VehicleRepositoryRemote(context: Context, private val needServerUpdate: Boolean) : VehicleRepository {

    private val vehicleDao = AppDatabase.create(context).getVehicleDao()

    private val api = provideApi()

    override fun fetch(param: CoordinateParam): Single<List<Vehicle>> {

        return vehicleDao
                .get()
                .flatMap {
                    if (!it.isNullOrEmpty() && !needServerUpdate) {
                        Single.just(it)
                    } else {
                        vehicleDao.delete()
                        api.getVehicle(
                            param.lat1,
                            param.lon1,
                            param.lat2,
                            param.lon2
                        )
                            .map {vehicles ->
                                vehicles.poiList
                            }
                            .doOnSuccess {
                                if (it != null) {
                                    vehicleDao.insert(it)
                                }
                            }
                    }

                }.map { vehicleResponse ->
                    vehicleResponse.map { it.transform() }
                }
    }
}
