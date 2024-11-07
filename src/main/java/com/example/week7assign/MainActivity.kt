package com.example.week7assign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week7assign.route.AppRouting
import com.example.week7assign.ui.theme.Week7AssignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week7AssignTheme {
                AppRouting() // No need to pass the ViewModel explicitly
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    RestaurantApp(modifier = Modifier.padding(innerPadding))
//                }
            }
        }
    }
}