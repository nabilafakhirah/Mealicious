package com.example.mealicious.ui.screens.detail.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mealicious.ui.theme.Typography

@Composable
fun IngredientItemView(
    ingredient: String,
    measurement: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = ingredient,
            style = Typography.body2
        )
        Text(
            text = measurement,
            style = Typography.body2
        )
    }
}