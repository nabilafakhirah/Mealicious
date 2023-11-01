package com.example.mealicious.ui.screens.mealsbycategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mealicious.ui.theme.mustard
import com.example.mealicious.ui.widget.MealsListView
import com.example.mealicious.ui.widget.SearchBarView
import com.example.mealicious.ui.widget.TopBarView

@Composable
fun MealsByCategoryScreen(
    category: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MealsByCategoryViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getMealsByCategory(category)
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
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBarView(
                modifier = Modifier.padding(top = 16.dp),
                onSearch = {

                }
            )
            if (state.value.isLoading) {
                CircularProgressIndicator(
                    color = mustard
                )
            }
            MealsListView(
                mealsList = state.value.mealsList,
                onClickItem = {
                    // to do
                }
            )
        }
    }
}