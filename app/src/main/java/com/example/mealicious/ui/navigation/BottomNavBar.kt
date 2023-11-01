package com.example.mealicious.ui.navigation

import com.example.mealicious.R
import com.example.mealicious.ui.navigation.Destinations.BOOKMARK_HOME_ROUTE
import com.example.mealicious.ui.navigation.Destinations.RECIPE_HOME_ROUTE

sealed class BottomNavItem(var title:String, var icon:Int, var screenRoute:String){

    object Home : BottomNavItem("Home", R.drawable.ic_menu_home, RECIPE_HOME_ROUTE)
    object Bookmarks: BottomNavItem("Bookmarks",R.drawable.ic_menu_bookmark, BOOKMARK_HOME_ROUTE)
}