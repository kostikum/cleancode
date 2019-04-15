package com.kostikum.cleancode.presentation.test.mvvm

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.kostikum.cleancode.R
import com.kostikum.cleancode.app.UseCaseProvider
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_test_mvp_mvvm.*

class TestMvvmActivity : Activity() {
    private lateinit var viewModel: MvvmViewModel

    private val vehicleUseCase = UseCaseProvider.provideGetVehicleUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_mvp_mvvm)

        viewModel = TestMvvmViewModelDefault()

        viewModel.setHelloTextListener(object : HelloTextListener {
            override fun onUpdated(value: String) {
                helloTextView.text = value
            }
        })

        helloTextView.setOnClickListener {

        }
    }

    private var disposable: Disposable? = null

    private fun observeVehicle() {
        disposable = vehicleUseCase
            .get()
            .subscribe({list ->
                Toast.makeText(this, "List size " + list.size, Toast.LENGTH_SHORT).show()
            }, {e ->
                Toast.makeText(this, "ERROR" + e, Toast.LENGTH_SHORT).show()
            })
    }

    override fun onResume() {
        super.onResume()
        viewModel.reloadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}