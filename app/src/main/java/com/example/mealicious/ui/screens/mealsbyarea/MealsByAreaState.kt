package com.example.mealicious.ui.screens.mealsbyarea

import com.example.mealicious.data.model.response.MealsResponse

data class MealsByAreaState(
    val mealsList: List<MealsResponse.Meal> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
