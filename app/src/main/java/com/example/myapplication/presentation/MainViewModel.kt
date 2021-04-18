package com.example.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.Address
import com.example.myapplication.domain.GetPerson
import com.example.myapplication.domain.Name
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPerson: GetPerson,
) : ViewModel() {

    val name = MutableLiveData("")
    val address = MutableLiveData("")

    fun onSimulateClick() {
        viewModelScope.launch {
            val person = getPerson(id = "simulation")
            name.postValue(formatName(person.name))
            address.postValue(formatAddress(person.address))
        }
    }

    private fun formatAddress(address: Address) = "${address.zip}, ${address.street} ${address.house}, ${address.city}"

    private fun formatName(name: Name) = "${name.firstName} ${name.lastName}"
}
