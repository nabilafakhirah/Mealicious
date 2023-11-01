package com.example.mealicious.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class CategoryResponse(
    @Json(name="meals")
    val meals: List<CategoryName>
) {
    @Parcelize
    data class CategoryName(
        @Json(name="strCategory")
        val strCategory: String
    ) : Parcelable
}
