package com.kostikum.cleancode.data.entity.vehicle

import com.google.gson.annotations.SerializedName

internal class VehiclePoiResponse (

    @SerializedName("poiList")
    val poiList: List<VehicleResponse>? = null

)
