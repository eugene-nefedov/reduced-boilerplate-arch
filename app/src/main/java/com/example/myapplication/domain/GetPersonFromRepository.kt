package com.example.myapplication.domain

class GetPersonFromRepository : GetPerson {

    override suspend fun invoke(id: String): Person {
        return Person(
            name = Name(firstName = "Sherlock", lastName = "Holmes"),
            address = Address(zip = "NW1 6XE", city = "London", "Baker Street", house = "221b")
        )
    }
}
