package com.example.mealicious.util

import com.example.mealicious.data.model.response.MealDetailResponse
import com.example.mealicious.data.model.MealDetail
import com.example.mealicious.data.model.entity.MealEntity

fun MealDetailResponse.MealDetailJson.mealDetailMapper(): MealDetail {
    val ingredientsList = listOf(
        "${this.strIngredient1}  ${this.strMeasure1}",
        "${this.strIngredient2}  ${this.strMeasure2}",
        "${this.strIngredient3}  ${this.strMeasure3}",
        "${this.strIngredient4}  ${this.strMeasure4}",
        "${this.strIngredient5}  ${this.strMeasure5}",
        "${this.strIngredient6}  ${this.strMeasure6}",
        "${this.strIngredient7}  ${this.strMeasure7}",
        "${this.strIngredient8}  ${this.strMeasure8}",
        "${this.strIngredient9}  ${this.strMeasure9}",
        "${this.strIngredient10}  ${this.strMeasure10}",
        "${this.strIngredient11}  ${this.strMeasure11}",
        "${this.strIngredient12}  ${this.strMeasure12}",
        "${this.strIngredient13}  ${this.strMeasure13}",
        "${this.strIngredient14}  ${this.strMeasure14}",
        "${this.strIngredient15}  ${this.strMeasure15}",
        "${this.strIngredient16}  ${this.strMeasure16}",
        "${this.strIngredient17}  ${this.strMeasure17}",
        "${this.strIngredient18}  ${this.strMeasure18}",
        "${this.strIngredient19}  ${this.strMeasure19}",
        "${this.strIngredient20}  ${this.strMeasure20}",
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

fun MealEntity.mealDetailMapper(): MealDetail {
    return MealDetail(
        idMeal = this.idMeal,
        strMeal = this.strMeal,
        strCategory = this.strCategory,
        strArea = this.strArea,
        strInstructions = this.strInstructions,
        strMealThumb = this.strMealThumb,
        strTags = this.strTags,
        strYoutube = this.strYoutube,
        ingredientsMeasurements = this.ingredientsMeasurements,
        strSource = this.strSource
    )
}

fun MealDetail.mealEntityMapper(): MealEntity {
    return MealEntity(
        idMeal = this.idMeal,
        strMeal = this.strMeal,
        strCategory = this.strCategory,
        strArea = this.strArea,
        strInstructions = this.strInstructions,
        strMealThumb = this.strMealThumb,
        strTags = this.strTags.orEmpty(),
        strYoutube = this.strYoutube.orEmpty(),
        ingredientsMeasurements = this.ingredientsMeasurements,
        strSource = this.strSource.orEmpty()
    )
}