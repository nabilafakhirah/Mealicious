package com.example.mealicious.ui.screens.bookmarkdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mealicious.data.repository.MealStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkDetailViewModel @Inject constructor(
    private val mealStorageRepository: MealStorageRepository
): ViewModel() {
    private val _state = mutableStateOf(BookmarkDetailState())
    val state: State<BookmarkDetailState> = _state

    fun getBookmarkDetail(idMenu: String) {
        val result = mealStorageRepository.getMealDetail(idMenu)
        _state.value = BookmarkDetailState(
            mealDetail = result
        )
    }
}