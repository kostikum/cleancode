package com.kostikum.cleancode.data.entity.vehicle

import com.google.gson.annotations.SerializedName

internal class CoordinateResponse (

    @SerializedName("latitude")
    val latitude: Double,

    @SerializedName("longitude")
    val longitude: Double

)
