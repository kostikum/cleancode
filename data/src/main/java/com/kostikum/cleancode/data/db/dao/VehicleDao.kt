package com.kostikum.cleancode.data.db.dao

import android.arch.persistence.room.*
import com.kostikum.cleancode.data.entity.vehicle.VehicleResponse
import com.kostikum.cleancode.data.entity.vehicle.vehicleTableId
import com.kostikum.cleancode.data.entity.vehicle.vehicleTableName
import io.reactivex.Completable
import io.reactivex.Single

@Dao
internal interface VehicleDao {

    @Query("SELECT * FROM $vehicleTableName")
    fun get(): Single<List<VehicleResponse>>

    @Query("SELECT * FROM $vehicleTableName WHERE $vehicleTableId = :id LIMIT 1")
    fun getById(id: Int): Single<List<VehicleResponse>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vehicles: List<VehicleResponse>): Unit

    @Query("DELETE FROM $vehicleTableName")
    fun delete(): Unit

}
