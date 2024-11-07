package com.example.week7assign.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week7assign.model.Restaurant
import com.example.week7assign.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel : ViewModel() {

    private val repository = RestaurantRepository()

    private val _restaurantList = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurantList: StateFlow<List<Restaurant>> = _restaurantList

    private val _currentRestaurant = MutableStateFlow<Restaurant?>(null)
    val currentRestaurant: StateFlow<Restaurant?> = _currentRestaurant

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        viewModelScope.launch {
            try {
                _restaurantList.value = repository.fetchRestaurants()
            } catch (e: Exception) {
                e.printStackTrace() // Handle the error in your production code
            }
        }
    }
//private fun loadRestaurants() {
//    viewModelScope.launch {
//        try {
//            val restaurants = repository.fetchRestaurants()
//            _restaurantList.value = restaurants
//            Log.d("RestaurantViewModel", "Fetched restaurants: $restaurants")
//        } catch (e: Exception) {
//            Log.e("RestaurantViewModel", "Error fetching data: ${e.message}")
//        }
//    }
//}

    fun setRestaurant(id: Int) {
        _currentRestaurant.value = _restaurantList.value.find { it.id == id }
    }
}