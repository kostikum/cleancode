package com.kostikum.cleancode.presentation.test.mvp

import android.app.Activity
import android.os.Bundle
import com.kostikum.cleancode.R
import kotlinx.android.synthetic.main.activity_test_mvp_mvvm.*

class TestMvpActivity : Activity(), TestView {

    lateinit var presenter: TestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_mvp_mvvm)
        presenter = TestPresenterDefault(this)

        helloTextView.setOnClickListener{
            presenter.onHelloClick()
        }
    }

    override fun showHelloText(value: String) {
        helloTextView.text = value;
    }

}
