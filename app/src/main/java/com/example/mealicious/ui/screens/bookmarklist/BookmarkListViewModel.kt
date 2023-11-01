package com.example.mealicious.ui.screens.bookmarklist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mealicious.data.repository.MealStorageRepository
import com.example.mealicious.util.mealDetailMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkListViewModel @Inject constructor(
    private val mealStorageRepository: MealStorageRepository
): ViewModel() {
    private val _state = mutableStateOf(BookmarkListState())
    val state: State<BookmarkListState> = _state

    init {
        getBookmarks()
    }

    private fun getBookmarks() {
        val result = mealStorageRepository.getBookmarkedMeals()
        _state.value = BookmarkListState(
            mealsList = result
        )
    }
}