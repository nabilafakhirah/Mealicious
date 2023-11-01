package com.example.mealicious.ui.screens.area

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mealicious.ui.navigation.Destinations.MEALS_BY_AREA_ROUTE
import com.example.mealicious.ui.theme.mustard
import com.example.mealicious.ui.widget.CategoryItemView
import com.example.mealicious.ui.widget.TopBarView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AreaScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AreaViewModel = hiltViewModel()
) {
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.value.isLoading) {
                CircularProgressIndicator(
                    color = mustard
                )
            }
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
            ) {
                items(state.value.areaList.size) { index ->
                    val areaName = state.value.areaList[index]
                    CategoryItemView(
                        text = areaName.strArea,
                        onClick = {
                            navController.navigate(
                                "${MEALS_BY_AREA_ROUTE}/{area}".replace(
                                    oldValue = "{area}",
                                    newValue = it
                                )
                            )
                        },
                    )
                }
            }
        }
    }
}