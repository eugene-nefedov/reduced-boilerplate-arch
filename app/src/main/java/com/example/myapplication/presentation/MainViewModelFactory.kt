package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.GetPersonFromRepository

class MainViewModelFactory : ViewModelProvider.Factory {

    private val getPersonFromRepository = GetPersonFromRepository()

    override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM {
        return MainViewModel(
            getPerson = getPersonFromRepository
        ) as VM
    }
}
