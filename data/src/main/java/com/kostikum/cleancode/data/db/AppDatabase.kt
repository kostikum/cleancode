package com.kostikum.cleancode.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.kostikum.cleancode.data.db.dao.VehicleDao
import com.kostikum.cleancode.data.entity.vehicle.VehicleResponse

@Database(entities = [VehicleResponse::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DB_NAME = "vehicleDb"

        fun create(context: Context) : AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
        }
    }

    abstract fun getVehicleDao() : VehicleDao

}
