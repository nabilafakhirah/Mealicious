package com.example.mealicious.ui.screens.area

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
class AreaViewModel @Inject constructor(
    private val mealRepository: MealRepository
): ViewModel() {
    private val _state = mutableStateOf(AreaState())
    val state: State<AreaState> = _state

    init {
        getAreas()
    }

    private fun getAreas() {
        val areaResponse = mealRepository.getArea()
        areaResponse.onEach { result ->
            when(result) {
                is DataResult.Success -> {
                    _state.value = AreaState(
                        areaList = result.data?.meals.orEmpty(),
                        isError = false,
                        isLoading = false,
                    )
                }
                is DataResult.Error -> {
                    _state.value = AreaState(
                        isError = true,
                        isLoading = false,
                    )
                }
                is DataResult.Loading -> {
                    _state.value = AreaState(
                        isError = false,
                        isLoading = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}