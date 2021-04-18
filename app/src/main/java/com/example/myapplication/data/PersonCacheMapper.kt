package com.example.myapplication.data

import com.example.myapplication.cache.CachedPerson
import com.example.myapplication.domain.Person

interface PersonCacheMapper {

    fun map(cached: CachedPerson): Person

    fun map(id: String, person: Person): CachedPerson
}
