package com.example.mealicious.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mealicious.R
import com.example.mealicious.ui.navigation.Destinations
import com.example.mealicious.ui.navigation.Destinations.AREA_LIST_ROUTE
import com.example.mealicious.ui.navigation.Destinations.CATEGORY_LIST_ROUTE
import com.example.mealicious.ui.theme.Typography
import com.example.mealicious.ui.theme.mustard
import com.example.mealicious.ui.widget.SearchBarView

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = stringResource(id = R.string.what_to_cook_today),
            style = Typography.h5.copy(color = mustard)
        )
        SearchBarView(
            modifier = Modifier.padding(top = 16.dp),
            onSearch = {
                navController.navigate(
                    "${Destinations.SEARCH_MEALS_ROUTE}/{name}".replace(
                        oldValue = "{name}",
                        newValue = it
                    )
                )
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HomeCategoryItem(
                modifier = Modifier.padding(end = 16.dp),
                text = stringResource(id = R.string.by_category),
                imageId = R.drawable.img_by_category,
                onClick = {
                    navController.navigate(CATEGORY_LIST_ROUTE)
                }
            )
            HomeCategoryItem(
                text = stringResource(id = R.string.by_area),
                imageId = R.drawable.img_by_area,
                onClick = {
                    navController.navigate(AREA_LIST_ROUTE)
                }
            )
        }
    }
}

@Composable
private fun HomeCategoryItem(
    text: String,
    imageId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.clickable {
                onClick()
            },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = mustard,
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.size(150.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = imageId),
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = text,
                style = Typography.h5,
            )
        }
    }
}