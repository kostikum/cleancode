package com.kostikum.cleancode.presentation.screen.vehicle.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kostikum.cleancode.R
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle

class VehicleListAdapter(private val dataSet: List<Vehicle>) : RecyclerView.Adapter<VehicleListViewHolder>() {

    private var mListener: OnItemClickListener? = null

    fun setListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleListViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vehicle_list, parent, false)

        return VehicleListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleListViewHolder, position: Int) {
        val vehicle = dataSet[position]
        holder.bindViewHolder(vehicle)
        holder.itemView.setOnClickListener {
            mListener?.onClick(vehicle)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    interface OnItemClickListener {
        fun onClick(vehicle: Vehicle)
    }
}
