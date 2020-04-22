package com.kostikum.cleancode.data.net

import com.kostikum.cleancode.data.entity.vehicle.VehiclePoiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiRest {

    @GET("korean.json")
    fun getVehicle(
        @Query("p1Lat") p1Lat: Double,
        @Query("p1Lon") p1Lon: Double,
        @Query("p2Lat") p2Lat: Double,
        @Query("p2Lon") p2Lon: Double) : Single<VehiclePoiResponse>

}
