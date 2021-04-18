package com.example.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    val name = MutableLiveData("")
    val address = MutableLiveData("")

    fun onSimulateClick() {
        name.postValue("Name")
        address.postValue("Address")
    }
}
