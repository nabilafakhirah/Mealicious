package com.example.mealicious.ui.screens.bookmarklist

import com.example.mealicious.data.model.MealDetail
import com.example.mealicious.data.model.entity.MealEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class BookmarkListState(
    val mealsList: Flow<List<MealEntity>> = emptyFlow(),
)
