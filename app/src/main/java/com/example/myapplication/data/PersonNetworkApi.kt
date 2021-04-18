package com.example.myapplication.data

import com.example.myapplication.remote.PersonNetworkResponse

interface PersonNetworkApi {

    suspend fun getPerson(id: String): PersonNetworkResponse
}
