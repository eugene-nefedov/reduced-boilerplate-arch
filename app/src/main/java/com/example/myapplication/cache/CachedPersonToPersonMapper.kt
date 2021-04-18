package com.example.myapplication.cache

import com.example.myapplication.data.PersonCacheMapper
import com.example.myapplication.domain.Address
import com.example.myapplication.domain.Name
import com.example.myapplication.domain.Person

class CachedPersonToPersonMapper : PersonCacheMapper {

    override fun map(cached: CachedPerson): Person {
        return Person(
            name = Name(
                firstName = cached.firstName,
                lastName = cached.lastName,
            ),
            address = Address(
                zip = cached.zip,
                city = cached.city,
                street = cached.street,
                house = cached.house,
            )
        )
    }

    override fun map(id: String, person: Person): CachedPerson {
        return CachedPerson(
            id = id,
            firstName = person.name.firstName,
            lastName = person.name.lastName,
            zip = person.address.zip,
            city = person.address.city,
            street = person.address.street,
            house = person.address.house,
        )
    }
}
