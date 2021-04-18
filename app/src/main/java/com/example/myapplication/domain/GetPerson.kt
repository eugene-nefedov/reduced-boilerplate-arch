package com.example.myapplication.domain

interface GetPerson {

    suspend operator fun invoke(id: String): Person
}
