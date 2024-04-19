package com.route.mealsapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.mealsapp.model.MealItem
import com.route.mealsapp.ui.theme.MealsAppTheme
import com.route.mealsapp.ui.theme.Purple
import com.route.mealsapp.ui.theme.PurpleGrey

@Composable
fun MainContent(vm: MainViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit) {
        vm.getMeals()
    }

    MealsAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn {
                items(
                    count = vm.mealsList.size,
                ) { position ->
                    MealCard(
                        meal = vm.mealsList[position],
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MealCard(meal: MealItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Purple, RoundedCornerShape(4.dp))
            .clickable {
                // to do
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GlideImage(
            model = meal.imgUrl,
            contentDescription = "${meal.name} photo",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(PurpleGrey)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Column {

            Text(
                text = meal.name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = meal.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis

            )

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun MainContentPreview() {
    MainContent()
}