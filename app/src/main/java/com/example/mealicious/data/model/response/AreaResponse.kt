package com.example.mealicious.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class AreaResponse(
    @Json(name="meals")
    val meals: List<AreaName>
) {
    @Parcelize
    data class AreaName(
        @Json(name="strCategory")
        val strArea: String
    ) : Parcelable
}
