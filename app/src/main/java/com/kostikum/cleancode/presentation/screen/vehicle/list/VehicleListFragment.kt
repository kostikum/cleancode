package com.kostikum.cleancode.presentation.screen.vehicle.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.kostikum.cleancode.R
import com.kostikum.cleancode.domain.entity.vehicle.FleetType
import com.kostikum.cleancode.domain.entity.vehicle.Vehicle
import com.kostikum.cleancode.presentation.base.BaseMvvmFragment
import com.kostikum.cleancode.presentation.screen.vehicle.VehicleMapsActivity
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_vehicle_list.*

class VehicleListFragment : BaseMvvmFragment<VehicleListViewModel>() {

    companion object {
        fun getInstance() : VehicleListFragment {
            return VehicleListFragment()
        }
    }

    private var vehicleStateDisposable: Disposable? = null

    override fun provideLayoutId() = R.layout.fragment_vehicle_list
    override fun provideViewModel(): VehicleListViewModel {
        return ViewModelProviders.of(activity!!, VehicleLIstViewModelFactory()).get(VehicleListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val behavior = BottomSheetBehavior.from(bottomSheetLayout)
        view.post{
            behavior.peekHeight = resources.getDimensionPixelSize(R.dimen.vehicle_bottom_sheet_peek)
            behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        }
    }

    private fun observeVehicleState() {
        viewModel
            .vehicleState
            .observe(this, object : Observer<VehicleState> {
                override fun onChanged(state: VehicleState?) {
                    if (state != null) {
                        processState(state)
                    }
                }
            })
    }

    override fun initView() {
        observeVehicleState()
    }

    private fun processState(state: VehicleState) {
        when (state) {
            is VehicleState.Progress -> {
                bottomSheetProgressBar.visibility = View.VISIBLE
            }
            is VehicleState.Done -> {
                bottomSheetProgressBar.visibility = View.GONE
                val list = state.vehicleList
                Toast.makeText(context, list.size.toString(), Toast.LENGTH_LONG).show()
            }
            is VehicleState.Error -> {
                bottomSheetProgressBar.visibility = View.GONE
                val error = state.throwable
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val activity = activity as VehicleMapsActivity

        activity.moveToVehicle(Vehicle(5, 20.5, 20.5, FleetType.TAXI, 454.56))
    }

    override fun onDestroy() {
        super.onDestroy()
        vehicleStateDisposable?.dispose()
    }
}
