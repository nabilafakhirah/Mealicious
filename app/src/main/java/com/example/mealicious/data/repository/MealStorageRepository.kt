package com.example.mealicious.data.repository

import com.example.mealicious.data.model.entity.MealEntity
import kotlinx.coroutines.flow.Flow

interface MealStorageRepository {
    fun getBookmarkedMeals(): Flow<List<MealEntity>>

    fun getMealDetail(idMeal: String): Flow<List<MealEntity>>

    suspend fun addMeal(meal: MealEntity)

    suspend fun deleteMeal(meal: MealEntity)
}