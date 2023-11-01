package com.example.mealicious.ui.screens.detail

import com.example.mealicious.data.model.MealDetail

data class MealDetailState(
    val mealDetail: MealDetail? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
