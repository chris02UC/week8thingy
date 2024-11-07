package com.example.week7assign.model

data class Restaurant(
    val id: Int,
    val name: String,
    val rating: Double,
    val ratingCount: Int,
    val distance: Double,
    val location: String,
    val description: String
)