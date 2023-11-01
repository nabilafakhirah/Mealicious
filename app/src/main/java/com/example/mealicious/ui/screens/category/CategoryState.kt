package com.example.mealicious.ui.screens.category

import com.example.mealicious.data.model.response.CategoryResponse

data class CategoryState(
    val categoryList: List<CategoryResponse.CategoryName> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false,
)