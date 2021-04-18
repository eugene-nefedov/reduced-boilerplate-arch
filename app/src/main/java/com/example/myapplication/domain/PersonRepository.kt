package com.example.myapplication.domain

import com.example.myapplication.domain.Person

interface PersonRepository {

    suspend fun getPerson(id: String): Person
}
