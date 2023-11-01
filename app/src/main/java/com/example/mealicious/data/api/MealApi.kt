package com.example.mealicious.data.api

import com.example.mealicious.data.model.response.AreaResponse
import com.example.mealicious.data.model.response.CategoryResponse
import com.example.mealicious.data.model.response.MealDetailResponse
import com.example.mealicious.data.model.response.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("list.php")
    suspend fun getCategory(
        @Query("c") category: String = "list",
    ): CategoryResponse

    @GET("list.php")
    suspend fun getArea(
        @Query("a") category: String = "list",
    ): AreaResponse

    @GET("lookup.php")
    suspend fun getMealDetail(
        @Query("i") id: String,
    ): MealDetailResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String,
    ): MealsResponse

    @GET("filter.php")
    suspend fun getMealsByArea(
        @Query("a") area: String,
    ): MealsResponse

    @GET("search.php")
    suspend fun searchMeals(
        @Query("s") name: String,
    ): MealDetailResponse
}