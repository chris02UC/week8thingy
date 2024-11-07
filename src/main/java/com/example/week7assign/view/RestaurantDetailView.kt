package com.example.week7assign.view


import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.week7assign.R
import com.example.week7assign.data.DataSource
import com.example.week7assign.model.Restaurant
import com.example.week7assign.viewmodel.RestaurantViewModel

@Composable
fun RestaurantDetailView(
    restaurantId: Int,
    navController: NavController,
    viewModel: RestaurantViewModel = viewModel()
) {
    viewModel.setRestaurant(restaurantId)
    val restaurant = viewModel.currentRestaurant.collectAsState().value

    if (restaurant != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 48.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Restaurant Info",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Text(
                text = restaurant.name,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "⭐",
                    color = Color(0xFFFBC02D),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${restaurant.rating}",
                    color = Color(0xFFFBC02D),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = " out of ${restaurant.ratingCount} reviews • ${restaurant.location}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Text(
                text = "Located on ${restaurant.distance} km from your house",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .shadow(elevation = 14.dp, shape = RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholderimage),
                    contentDescription = "Default restaurant image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = restaurant.description,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = Color(0xFF00aaff),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable(onClick = {
                        // Implement "Get Directions" functionality here
                    }),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Get Directions",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button to go back, currently commented out but kept for potential use
//            Button(
//                onClick = { navController.popBackStack() },
//                modifier = Modifier.fillMaxWidth().height(48.dp)
//            ) {
//                Text(text = "Back")
//            }
        }
    } else {
        Text(
            text = "Loading restaurant details...",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantDetailViewPreview() {
//    val restaurant = DataSource().loadRestaurant()[0]
//    RestaurantDetailView(viewModel = RestaurantViewModel(), restaurant = restaurant)
}
