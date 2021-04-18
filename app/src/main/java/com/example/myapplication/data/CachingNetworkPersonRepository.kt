package com.example.myapplication.data

import com.example.myapplication.domain.Person
import com.example.myapplication.domain.PersonRepository

class CachingNetworkPersonRepository(
    private val cache: PersonCache,
    private val cacheMapper: PersonCacheMapper,
    private val networkApi: PersonNetworkApi,
    private val networkApiMapper: PersonNetworkApiMapper,
) : PersonRepository {

    override suspend fun getPerson(id: String): Person {
        val cachedPerson = cache.getPerson(id)
        return if (cachedPerson == null) {
            requestFromNetworkAndCache(id)
        } else {
            cacheMapper.map(cachedPerson)
        }
    }

    private suspend fun requestFromNetworkAndCache(id: String): Person {
        val response = networkApi.getPerson(id)
        val person = networkApiMapper.map(response)

        cache.putPerson(id, cacheMapper.map(id, person))

        return person
    }
}
