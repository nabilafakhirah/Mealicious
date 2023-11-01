package com.example.mealicious.data.repository

import com.example.mealicious.data.dao.MealDao
import com.example.mealicious.data.model.entity.MealEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealStorageRepositoryImpl @Inject constructor(
    private val mealDao: MealDao
): MealStorageRepository {
    override fun getBookmarkedMeals(): Flow<List<MealEntity>> {
        return mealDao.getBookmarkedMeals()
    }

    override fun getMealDetail(idMeal: String): Flow<List<MealEntity>> {
        return mealDao.getMealDetail(idMeal)
    }

    override suspend fun addMeal(meal: MealEntity) {
        mealDao.addMeal(meal)
    }

    override suspend fun deleteMeal(meal: MealEntity) {
        mealDao.addMeal(meal)
    }

}