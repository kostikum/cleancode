package com.kostikum.cleancode.data.entity.vehicle

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

internal const val vehicleTableName = "vehicle"
//internal const val coordinateTableName = "coordinate"
internal const val vehicleTableId = "id"

@Entity(tableName = vehicleTableName)
internal class VehicleResponse (

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = vehicleTableId)
    val id: Int,

    @SerializedName("coordinate")
    @Embedded
    val coordinate: CoordinateResponse,

    @SerializedName("fleetType")
    val fleetType: String,

    @SerializedName("heading")
    val heading: Double

)
