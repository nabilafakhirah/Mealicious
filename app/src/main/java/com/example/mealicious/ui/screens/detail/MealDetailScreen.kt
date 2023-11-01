package com.example.mealicious.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mealicious.ui.screens.detail.widget.MealDetailView
import com.example.mealicious.ui.theme.mustard
import com.example.mealicious.ui.widget.TopBarView

@Composable
fun MealDetailScreen(
    mealId: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MealDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getMealDetail(mealId)
    }
    val state = viewModel.state
    Scaffold(
        topBar = {
            TopBarView(
                onClickBack = {
                    navController.navigateUp()
                }
            )
        },
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 60.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            if (state.value.isLoading) {
                CircularProgressIndicator(
                    color = mustard
                )
            }
            val meal = state.value.mealDetail
            if (meal != null) {
                MealDetailView(meal = meal)
            }
        }
    }
}