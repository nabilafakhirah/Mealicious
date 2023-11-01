package com.example.mealicious.ui.screens.mealsbyarea

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
class MealsByAreaViewModel @Inject constructor(
    private val mealRepository: MealRepository
): ViewModel() {

    private val _state = mutableStateOf(MealsByAreaState())
    val state: State<MealsByAreaState> = _state

    fun getMealsByArea(area: String) {
        val mealsByAreaResponse = mealRepository.getMealsByArea(area)
        mealsByAreaResponse.onEach { result ->
            when(result) {
                is DataResult.Success -> {
                    _state.value = MealsByAreaState(
                        mealsList = result.data?.meals.orEmpty(),
                        isLoading = false,
                        isError = false,
                    )
                }
                is DataResult.Loading -> {
                    _state.value = MealsByAreaState(
                        isLoading = true,
                        isError = false,
                    )
                }
                is DataResult.Error -> {
                    _state.value = MealsByAreaState(
                        isLoading = false,
                        isError = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}