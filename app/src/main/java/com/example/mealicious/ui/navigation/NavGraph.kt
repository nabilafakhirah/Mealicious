package com.example.mealicious.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealicious.ui.navigation.Destinations.RECIPE_HOME_ROUTE
import com.example.mealicious.ui.screens.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RECIPE_HOME_ROUTE
    ) {
        composable(RECIPE_HOME_ROUTE) {
            HomeScreen()
        }
    }

}

object Destinations {
    const val RECIPE_HOME_ROUTE = "recipe_home_route"
    const val BOOKMARK_HOME_ROUTE = "bookmark_home_route"
}