package com.example.myapplication.remote

import com.example.myapplication.data.PersonNetworkApiMapper
import com.example.myapplication.domain.Address
import com.example.myapplication.domain.Name
import com.example.myapplication.domain.Person

class PersonNetworkResponseMapper : PersonNetworkApiMapper {

    override fun map(networkResponse: PersonNetworkResponse): Person {
        return Person(
            name = Name(
                firstName = networkResponse.firstName,
                lastName = networkResponse.lastName,
            ),
            address = Address(
                zip = networkResponse.zip,
                city = networkResponse.city,
                street = networkResponse.street,
                house = networkResponse.house,
            )
        )
    }
}
