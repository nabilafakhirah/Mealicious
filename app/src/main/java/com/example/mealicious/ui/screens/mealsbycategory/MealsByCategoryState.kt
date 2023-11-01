package com.example.mealicious.ui.screens.mealsbycategory

import com.example.mealicious.data.model.response.MealsResponse

data class MealsByCategoryState(
    val mealsList: List<MealsResponse.Meal> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
