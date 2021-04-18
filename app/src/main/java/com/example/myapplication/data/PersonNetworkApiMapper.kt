package com.example.myapplication.data

import com.example.myapplication.domain.Person
import com.example.myapplication.remote.PersonNetworkResponse

interface PersonNetworkApiMapper {

    fun map(networkResponse: PersonNetworkResponse): Person
}
