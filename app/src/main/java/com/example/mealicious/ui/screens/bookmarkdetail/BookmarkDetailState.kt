package com.example.mealicious.ui.screens.bookmarkdetail

import com.example.mealicious.data.model.entity.MealEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class BookmarkDetailState(
    val mealDetail: Flow<List<MealEntity>> = emptyFlow(),
)
