package com.kostikum.cleancode.presentation.screen.vehicle.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import android.widget.TextView
import kotlinx.android.synthetic.main.item_vehicle_list.view.*

class VehicleListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val vehicleIdTextView: TextView = view.vehicle_id_text_view
    private val fleetTypeTextView: TextView = view.fleet_type_text_view
    private val coordinateLatTextView: TextView = view.coordinate_lat_text_view
    private val coordinateLonTextView: TextView = view.coordinate_lon_text_view
    private val headingTextView: TextView = view.heading_text_view

    fun bindViewHolder(vehicle: Vehicle) {
        vehicleIdTextView.text = vehicle.id.toString()
        fleetTypeTextView.text = vehicle.fleetType.toString()
        coordinateLatTextView.text = vehicle.lat.toString()
        coordinateLonTextView.text = vehicle.lon.toString()
        headingTextView.text = vehicle.heading.toString()
    }
}
