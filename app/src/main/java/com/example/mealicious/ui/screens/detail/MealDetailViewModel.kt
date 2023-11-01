package com.example.mealicious.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealicious.data.model.MealDetail
import com.example.mealicious.data.repository.MealRepository
import com.example.mealicious.data.repository.MealStorageRepository
import com.example.mealicious.ui.screens.category.CategoryState
import com.example.mealicious.util.DataResult
import com.example.mealicious.util.mealDetailMapper
import com.example.mealicious.util.mealEntityMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(
    private val mealRepository: MealRepository,
    private val mealStorageRepository: MealStorageRepository,
): ViewModel() {

    private val _state = mutableStateOf(MealDetailState())
    val state: State<MealDetailState> = _state

    fun getMealDetail(mealId: String) {
        val categoriesResponse = mealRepository.getMealDetail(mealId)
        categoriesResponse.onEach { result ->
            when(result) {
                is DataResult.Success -> {
                    val mealDetail = if (result.data?.meals?.isNotEmpty() == true) {
                        result.data.meals.first().mealDetailMapper()
                    } else {
                        null
                    }
                    _state.value = MealDetailState(
                        mealDetail = mealDetail,
                        isError = false,
                        isLoading = false,
                    )
                }
                is DataResult.Error -> {
                    _state.value = MealDetailState(
                        isError = true,
                        isLoading = false,
                    )
                }
                is DataResult.Loading -> {
                    _state.value = MealDetailState(
                        isError = false,
                        isLoading = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun saveMealToBookmark(mealDetail: MealDetail) = viewModelScope.launch {
        val mealEntity = mealDetail.mealEntityMapper()
        mealStorageRepository.addMeal(mealEntity)
    }
}