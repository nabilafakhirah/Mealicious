package com.example.mealicious.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class MealsResponse(
    @Json(name="meals")
    val meals: List<Meal>
) {
    @Parcelize
    data class Meal(
        @Json(name="strMeal")
        val strMeal: String,
        @Json(name="strMealThumb")
        val strMealThumb: String,
        @Json(name="idMeal")
        val idMeal: String
    ) : Parcelable
}
