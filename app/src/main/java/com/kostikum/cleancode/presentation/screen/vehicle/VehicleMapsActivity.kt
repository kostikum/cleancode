package com.kostikum.cleancode.presentation.screen.vehicle

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kostikum.cleancode.R
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import com.kostikum.cleancode.presentation.base.BaseMvvmActivity
import com.kostikum.cleancode.presentation.screen.vehicle.list.VehicleListFragment
import io.reactivex.Observable


class VehicleMapsActivity : BaseMvvmActivity<VehicleMapViewModel>(), OnMapReadyCallback {


    override fun provideLayoutId(): Int {
        return R.layout.activity_vehicle_maps
    }

    override fun provideViewModel(): VehicleMapViewModel {
        //простой вариант
        //return ViewModelProviders.of(this).get(VehicleMapViewModel::class.java)
        return ViewModelProviders.of(this, VehicleMapViewModelFactory()).get(VehicleMapViewModel::class.java)

    }

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        if (savedInstanceState == null) initList()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    public fun moveToVehicle(vehicle: Vehicle) {
        val sydney = LatLng(vehicle.lat, vehicle.lon)
        mMap?.addMarker(MarkerOptions().position(sydney).title(vehicle.fleetType.toString()))
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private fun initList() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, VehicleListFragment.getInstance())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
