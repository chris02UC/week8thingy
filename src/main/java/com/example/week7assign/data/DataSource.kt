package com.example.week7assign.data

import com.example.week7assign.R
import com.example.week7assign.model.Restaurant

class DataSource {
    fun loadRestaurant(): List<Restaurant> {
        return listOf(
            Restaurant(
                id = 1,
                name = "The Food Place",
                rating = 4.5,
                ratingCount = 120,
                distance = 2.3,
                location = "123 Main St",
                description = "The Food Place is a cozy neighborhood restaurant that specializes in comfort food, offering a menu filled with hearty dishes and classic favorites. Whether you're craving a delicious mac and cheese, a warm bowl of soup, or a home style roast, this sport guarantees a filling and satisfying meal that will remind you of home-cooked goodness. Perfect for family dinners or a relaxed night out, this restaurant is loved by locals for its welcoming atmosphere and generous portions."
            )
        )
    }
}