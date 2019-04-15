package com.kostikum.cleancode.domain.entity.vehicle

import com.kostikum.cleancode.domain.entity.DomainEntity

data class Vehicle (
    val id: Int,
    val lat: Double,
    val lon: Double,
    val fleetType: FleetType,
    val heading: Double
) : DomainEntity
