package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)

        handleSimulateClicks()
        listenNameState()
        listenAddressState()
    }

    private fun listenNameState() = viewModel.name.observe(this) { views.name.text = it }

    private fun listenAddressState() = viewModel.address.observe(this) { views.address.text = it }

    private fun handleSimulateClicks() {
        views.simulate.setOnClickListener {
            viewModel.onSimulateClick()
        }
    }
}
