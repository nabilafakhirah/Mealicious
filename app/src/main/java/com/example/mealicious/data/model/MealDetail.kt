package com.example.mealicious.data.model

data class MealDetail(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String?,
    val strYoutube: String?,
    val ingredientsMeasurements: List<Pair<String, String>>,
    val strSource: String?,
)
