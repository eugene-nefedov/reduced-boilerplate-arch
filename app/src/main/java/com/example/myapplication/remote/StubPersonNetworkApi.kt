package com.example.myapplication.remote

import com.example.myapplication.data.PersonNetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class StubPersonNetworkApi : PersonNetworkApi {

    override suspend fun getPerson(id: String): PersonNetworkResponse = withContext(Dispatchers.IO) {
        delay(2000L)
        return@withContext PersonNetworkResponse(
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
