package com.example.mealicious.ui.screens.mealsbycategory

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
class MealsByCategoryViewModel @Inject constructor(
    private val mealRepository: MealRepository
): ViewModel() {

    private val _state = mutableStateOf(MealsByCategoryState())
    val state: State<MealsByCategoryState> = _state

    fun getMealsByCategory(category: String) {
        val mealsByCategoryResponse = mealRepository.getMealsByCategory(category)
        mealsByCategoryResponse.onEach { result ->
            when(result) {
                is DataResult.Success -> {
                    _state.value = MealsByCategoryState(
                        mealsList = result.data?.meals.orEmpty(),
                        isLoading = false,
                        isError = false,
                    )
                }
                is DataResult.Loading -> {
                    _state.value = MealsByCategoryState(
                        isLoading = true,
                        isError = false,
                    )
                }
                is DataResult.Error -> {
                    _state.value = MealsByCategoryState(
                        isLoading = false,
                        isError = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}