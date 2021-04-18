package com.example.myapplication.remote

data class PersonNetworkResponse(
    val id: String,
    val firstName: String,
    val lastName: String,
    val zip: String,
    val city: String,
    val street: String,
    val house: String,
)
