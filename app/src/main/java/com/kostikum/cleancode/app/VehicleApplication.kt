package com.kostikum.cleancode.app

import android.app.Application

class VehicleApplication: Application() {

    companion object {
        lateinit var instance: VehicleApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
