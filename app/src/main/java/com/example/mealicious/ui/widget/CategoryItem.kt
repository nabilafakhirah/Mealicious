package com.example.mealicious.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mealicious.ui.theme.Typography
import com.example.mealicious.ui.theme.mustard

@Composable
fun CategoryItemView(
    text: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                onClick(text)
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
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = text,
                style = Typography.h5,
            )
        }
    }
}