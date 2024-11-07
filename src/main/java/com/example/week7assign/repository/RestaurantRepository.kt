package com.example.week7assign.repository

import com.example.week7assign.model.Restaurant
import com.example.week7assign.service.RestaurantApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantRepository {

    private val apiService: RestaurantApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2/") // Use 10.0.2.2 to access localhost from the Android emulator
      //     .baseUrl("http://localhost/") // Base URL for the API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(RestaurantApiService::class.java)
   }

    suspend fun fetchRestaurants(): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            apiService.getRestaurants()
        }
    }
}
