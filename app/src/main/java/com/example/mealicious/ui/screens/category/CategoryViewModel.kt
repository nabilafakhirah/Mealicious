package com.example.mealicious.ui.screens.category

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealicious.data.repository.MealRepository
import com.example.mealicious.util.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val mealRepository: MealRepository
): ViewModel() {
    private val _state = mutableStateOf(CategoryState())
    val state: State<CategoryState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        val categoriesResponse = mealRepository.getCategory()
        categoriesResponse.onEach { result ->
            when(result) {
                is DataResult.Success -> {
                    _state.value = CategoryState(
                        categoryList = result.data?.meals.orEmpty(),
                        isError = false,
                        isLoading = false,
                    )
                }
                is DataResult.Error -> {
                    _state.value = CategoryState(
                        isError = true,
                        isLoading = false,
                    )
                }
                is DataResult.Loading -> {
                    _state.value = CategoryState(
                        isError = false,
                        isLoading = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}