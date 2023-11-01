package com.example.mealicious.ui.screens.detail.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.mealicious.R
import com.example.mealicious.data.model.MealDetail
import com.example.mealicious.ui.theme.Typography
import com.example.mealicious.util.findParameterValue
import java.net.URI

@Composable
fun MealDetailView(
    meal: MealDetail,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(bottom = 20.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            model = meal.strMealThumb,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.img_by_category),
            error = painterResource(id = R.drawable.img_by_category),
            contentDescription = "",
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = meal.strMeal,
            style = Typography.subtitle1
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = stringResource(id = R.string.ingredients),
            style = Typography.subtitle2
        )
        meal.ingredientsMeasurements.forEach {
            if (it.first != null) {
                IngredientItemView(
                    ingredient = it.first,
                    measurement = it.second)
            }
        }
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = stringResource(id = R.string.how_to_make),
            style = Typography.subtitle2
        )
        Text(
            text = meal.strInstructions,
            style = Typography.body2
        )
        if (meal.strYoutube != null && meal.strYoutube.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                text = stringResource(id = R.string.video),
                style = Typography.subtitle2
            )
            val youtubeId = URI(meal.strYoutube).findParameterValue("v")
            YouTubePlayerView(
                videoId = youtubeId.orEmpty(),
            )
        }
    }
}