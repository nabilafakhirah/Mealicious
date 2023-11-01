package com.example.mealicious.ui.screens.area

import com.example.mealicious.data.model.response.AreaResponse
import com.example.mealicious.data.model.response.CategoryResponse

data class AreaState(
    val areaList: List<AreaResponse.AreaName> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false,
)