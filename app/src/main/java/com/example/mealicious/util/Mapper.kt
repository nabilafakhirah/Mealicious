package com.example.mealicious.util

import com.example.mealicious.data.model.response.MealDetailResponse
import com.example.mealicious.data.model.MealDetail

fun MealDetailResponse.MealDetailJson.mealDetailMapper(): MealDetail {
    val ingredientsList = listOf(
        Pair(this.strIngredient1, this.strMeasure1),
        Pair(this.strIngredient2, this.strMeasure2),
        Pair(this.strIngredient3, this.strMeasure3),
        Pair(this.strIngredient4, this.strMeasure4),
        Pair(this.strIngredient5, this.strMeasure5),
        Pair(this.strIngredient6, this.strMeasure6),
        Pair(this.strIngredient7, this.strMeasure7),
        Pair(this.strIngredient8, this.strMeasure8),
        Pair(this.strIngredient9, this.strMeasure9),
        Pair(this.strIngredient10, this.strMeasure10),
        Pair(this.strIngredient11, this.strMeasure11),
        Pair(this.strIngredient12, this.strMeasure12),
        Pair(this.strIngredient13, this.strMeasure13),
        Pair(this.strIngredient14, this.strMeasure14),
        Pair(this.strIngredient15, this.strMeasure15),
        Pair(this.strIngredient16, this.strMeasure16),
        Pair(this.strIngredient17, this.strMeasure17),
        Pair(this.strIngredient18, this.strMeasure18),
        Pair(this.strIngredient19, this.strMeasure19),
        Pair(this.strIngredient20, this.strMeasure20),
    )
    return MealDetail(
        idMeal = this.idMeal,
        strMeal = this.strMeal,
        strCategory = this.strCategory,
        strArea = this.strArea,
        strInstructions = this.strInstructions,
        strMealThumb = this.strMealThumb,
        strTags = this.strTags,
        strYoutube = this.strYoutube,
        ingredientsMeasurements = ingredientsList,
        strSource = this.strSource
    )
}