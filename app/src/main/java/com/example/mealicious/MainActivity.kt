package com.example.mealicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.mealicious.ui.navigation.NavGraph
import com.example.mealicious.ui.theme.MealiciousTheme
import com.example.mealicious.ui.widget.BottomNavigationView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealiciousTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationView(navController = navController)
                        }
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}