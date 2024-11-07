package com.example.week7assign.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.week7assign.R
import com.example.week7assign.data.DataSource
import com.example.week7assign.model.Restaurant
import com.example.week7assign.viewmodel.RestaurantViewModel

@Composable
fun RestaurantListView(
    navController: NavController,
    viewModel: RestaurantViewModel,
    modifier: Modifier = Modifier
) {
    val restaurantList = viewModel.restaurantList.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 48.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Restaurant List",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        restaurantList.forEach { restaurant ->
            RestaurantCard(restaurant = restaurant) {
                navController.navigate("RestaurantDetail/${restaurant.id}")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RestaurantListViewPreview() {
    val restaurant = DataSource().loadRestaurant()[0]
    Column {
        RestaurantCard(restaurant = restaurant, onClick = {})
    }
}