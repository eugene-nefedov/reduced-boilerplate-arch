package com.example.myapplication.data

import com.example.myapplication.cache.CachedPerson

interface PersonCache {

    suspend fun getPerson(id: String): CachedPerson?

    suspend fun putPerson(id: String, person: CachedPerson)
}
