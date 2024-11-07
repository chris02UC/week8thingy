package com.example.week7assign.service

import com.example.week7assign.model.Restaurant
import retrofit2.http.GET

interface RestaurantApiService {
    @GET("restaurant_api.php") // This endpoint should match your XAMPP setup
    suspend fun getRestaurants(): List<Restaurant>
}