package com.example.mealicious.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealicious.ui.navigation.Destinations.AREA_LIST_ROUTE
import com.example.mealicious.ui.navigation.Destinations.CATEGORY_LIST_ROUTE
import com.example.mealicious.ui.navigation.Destinations.MEALS_BY_AREA_ROUTE
import com.example.mealicious.ui.navigation.Destinations.MEALS_BY_CATEGORY_ROUTE
import com.example.mealicious.ui.navigation.Destinations.RECIPE_HOME_ROUTE
import com.example.mealicious.ui.screens.area.AreaScreen
import com.example.mealicious.ui.screens.category.CategoryScreen
import com.example.mealicious.ui.screens.home.HomeScreen
import com.example.mealicious.ui.screens.mealsbyarea.MealsByAreaScreen
import com.example.mealicious.ui.screens.mealsbycategory.MealsByCategoryScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RECIPE_HOME_ROUTE
    ) {
        composable(RECIPE_HOME_ROUTE) {
            HomeScreen(
                navController = navController
            )
        }
        composable(AREA_LIST_ROUTE) {
            AreaScreen(navController = navController)
        }
        composable(CATEGORY_LIST_ROUTE) {
            CategoryScreen(navController = navController)
        }
        composable("${MEALS_BY_AREA_ROUTE}/{area}") {
            val area = it.arguments?.getString("area") ?: ""
            MealsByAreaScreen(
                area = area,
                navController = navController
            )
        }
        composable("${MEALS_BY_CATEGORY_ROUTE}/{category}") {
            val category = it.arguments?.getString("category") ?: ""
            MealsByCategoryScreen(
                category = category,
                navController = navController
            )
        }
    }

}

object Destinations {
    const val RECIPE_HOME_ROUTE = "recipe_home_route"
    const val BOOKMARK_HOME_ROUTE = "bookmark_home_route"
    const val AREA_LIST_ROUTE = "area_list_route"
    const val CATEGORY_LIST_ROUTE = "category_list_route"
    const val MEALS_BY_AREA_ROUTE = "meals_by_area_route"
    const val MEALS_BY_CATEGORY_ROUTE = "meals_by_category_route"
}