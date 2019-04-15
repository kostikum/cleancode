package com.kostikum.cleancode.domain.entity.vehicle

import com.kostikum.cleancode.domain.entity.DomainEntity

class CoordinateParam (
    val lat1: Double,
    val lon1: Double,
    val lat2: Double,
    val lon2: Double
) : DomainEntity