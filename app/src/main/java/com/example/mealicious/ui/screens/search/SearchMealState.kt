package com.example.mealicious.ui.screens.search

import com.example.mealicious.data.model.response.MealsResponse

data class SearchMealState(
    val mealsList: List<MealsResponse.Meal> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
