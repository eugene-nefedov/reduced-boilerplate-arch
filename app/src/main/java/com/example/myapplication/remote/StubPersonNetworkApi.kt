package com.example.myapplication.remote

import com.example.myapplication.data.PersonNetworkApi

class StubPersonNetworkApi : PersonNetworkApi {

    override suspend fun getPerson(id: String): PersonNetworkResponse {
        Thread.sleep(2000L)
        return PersonNetworkResponse(
            id = "42",
            firstName = "Sherlock",
            lastName = "Holmes",
            zip = "NW1 6XE",
            city = "London",
            street = "Baker Street",
            house = "221b",
        )
    }
}
