package com.example.mealicious.ui.screens.bookmarkdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mealicious.ui.theme.mustard
import com.example.mealicious.ui.widget.MealDetailView
import com.example.mealicious.ui.widget.TopBarView
import com.example.mealicious.util.mealDetailMapper

@Composable
fun BookmarkDetailScreen(
    idMeal: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: BookmarkDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getBookmarkDetail(idMeal)
    }
    val bookmarkFlow = viewModel.state.value.mealDetail
    val mealEntity by bookmarkFlow.collectAsState(initial = emptyList())
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
            if (mealEntity.isNotEmpty()) {
                val mealDetail = mealEntity.first().mealDetailMapper()
                MealDetailView(
                    meal = mealDetail,
                    isBookmark = true,
                    onClickAction = {}
                )
            }
        }
    }
}