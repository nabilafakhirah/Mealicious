package com.example.mealicious.ui.screens.search

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
class SearchMealViewModel @Inject constructor(
    private val mealRepository: MealRepository
): ViewModel() {
    private val _state = mutableStateOf(SearchMealState())
    val state: State<SearchMealState> = _state

    fun searchMeals(name: String) {
        val searchMealsResponse = mealRepository.searchMeals(name)
        searchMealsResponse.onEach { result ->
            when(result) {
                is DataResult.Success -> {
                    _state.value = SearchMealState(
                        mealsList = result.data?.meals.orEmpty(),
                        isLoading = false,
                        isError = false,
                    )
                }
                is DataResult.Loading -> {
                    _state.value = SearchMealState(
                        isLoading = true,
                        isError = false,
                    )
                }
                is DataResult.Error -> {
                    _state.value = SearchMealState(
                        isLoading = false,
                        isError = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}