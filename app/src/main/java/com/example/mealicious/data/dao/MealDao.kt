package com.example.mealicious.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mealicious.data.model.entity.MealEntity
import com.example.mealicious.util.MEAL_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Query("SELECT * FROM $MEAL_TABLE ORDER BY strMeal ASC")
    fun getBookmarkedMeals(): Flow<List<MealEntity>>

    @Query("SELECT * FROM $MEAL_TABLE WHERE idMeal = :idMeal")
    fun getMealDetail(idMeal: String): Flow<List<MealEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeal(meal: MealEntity)

    @Delete
    suspend fun deleteNews(meal: MealEntity)
}