package com.example.myapplication.domain

class GetPersonFromRepository(
    private val repository: PersonRepository,
) : GetPerson {

    override suspend fun invoke(id: String): Person = repository.getPerson(id)
}
