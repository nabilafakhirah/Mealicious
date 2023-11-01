package com.example.mealicious.ui.screens.bookmarklist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mealicious.R
import com.example.mealicious.ui.navigation.Destinations
import com.example.mealicious.ui.theme.Typography
import com.example.mealicious.ui.theme.mustard
import com.example.mealicious.ui.widget.BookmarkListView
import com.example.mealicious.ui.widget.TopBarView
import com.example.mealicious.util.mealDetailMapper

@Composable
fun BookmarkListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: BookmarkListViewModel = hiltViewModel()
) {
    val bookmarkFlow = viewModel.state.value.mealsList
    val bookmarkList by bookmarkFlow.collectAsState(initial = emptyList())
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
            Text(
                text = stringResource(id = R.string.bookmarks),
                style = Typography.h5.copy(color = mustard)
            )

            val mealDetailList = bookmarkList.map {
                it.mealDetailMapper()
            }
            BookmarkListView(
                mealsList = mealDetailList,
                onClickItem = {
                    navController.navigate(
                        "${Destinations.BOOKMARK_DETAIL_ROUTE}/{mealId}".replace(
                            oldValue = "{mealId}",
                            newValue = it
                        )
                    )
                }
            )
        }
    }
}