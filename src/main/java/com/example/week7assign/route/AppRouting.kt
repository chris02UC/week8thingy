package com.example.week7assign.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.week7assign.view.RestaurantListView
import com.example.week7assign.view.RestaurantDetailView
import com.example.week7assign.viewmodel.RestaurantViewModel

enum class RestaurantScreen {
    RestaurantList,
    RestaurantDetail,
}

@Composable
fun AppRouting() {
    val viewModel: RestaurantViewModel = viewModel()
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RestaurantScreen.RestaurantList.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(route = RestaurantScreen.RestaurantList.name) {
                RestaurantListView(navController = navController, viewModel = viewModel)
            }

            composable(
                route = RestaurantScreen.RestaurantDetail.name + "/{restaurantId}",
                arguments = listOf(
                    navArgument("restaurantId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("restaurantId")
                if (restaurantId != null) {
                    RestaurantDetailView(restaurantId = restaurantId, navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}
