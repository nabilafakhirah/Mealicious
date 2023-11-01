package com.example.mealicious.data.repository

import com.example.mealicious.data.model.response.AreaResponse
import com.example.mealicious.data.model.response.CategoryResponse
import com.example.mealicious.data.model.response.MealDetailResponse
import com.example.mealicious.data.model.response.MealsResponse
import com.example.mealicious.util.DataResult
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    fun getCategory(): Flow<DataResult<CategoryResponse>>

    fun getArea(): Flow<DataResult<AreaResponse>>

    fun getMealDetail(id: String): Flow<DataResult<MealDetailResponse>>

    fun getMealsByCategory(category: String): Flow<DataResult<MealsResponse>>

    fun getMealsByArea(area: String): Flow<DataResult<MealsResponse>>

    fun searchMeals(name: String): Flow<DataResult<MealsResponse>>
}