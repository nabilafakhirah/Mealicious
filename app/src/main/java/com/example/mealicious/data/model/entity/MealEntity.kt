package com.example.mealicious.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mealicious.util.MEAL_TABLE

@Entity(tableName = MEAL_TABLE)
data class MealEntity(
    @PrimaryKey(autoGenerate = false)
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String,
    val strYoutube: String,
    val ingredientsMeasurements: List<String>,
    val strSource: String,
)
