package com.example.mealicious.ui.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealicious.R
import com.example.mealicious.data.model.response.MealsResponse
import com.example.mealicious.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MealsListView(
    mealsList: List<MealsResponse.Meal>,
    onClickItem: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
    ) {
        items(mealsList.size) { index ->
            val meal = mealsList[index]
            MealItemView(
                meal = meal,
                onClickItem = onClickItem,
            )
        }
    }
}

@Composable
private fun MealItemView(
    meal: MealsResponse.Meal,
    onClickItem: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                onClickItem(meal.idMeal)
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .padding(top = 8.dp),
                model = meal.strMealThumb,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.img_by_category),
                error = painterResource(id = R.drawable.img_by_category),
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = meal.strMeal,
                style = Typography.body1.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
            )
        }
    }
}