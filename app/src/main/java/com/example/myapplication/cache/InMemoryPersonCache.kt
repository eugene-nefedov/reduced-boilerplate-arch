package com.example.myapplication.cache

import com.example.myapplication.data.PersonCache

class InMemoryPersonCache : PersonCache {

    private val cachedPersons = mutableMapOf<String, CachedPerson>()

    override suspend fun getPerson(id: String): CachedPerson? = cachedPersons[id]

    override suspend fun putPerson(id: String, person: CachedPerson) {
        cachedPersons[id] = person
    }
}
