package com.route.mealsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.mealsapp.R
import com.route.mealsapp.model.MealItem

@Composable
fun MainContent(vm: MainViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit) {
        vm.getMeals()
    }

    Scaffold(
        topBar = {
            MealTopAppBar()
        }
    ) {
        LazyColumn(
            contentPadding = it
        ) {
            items(
                count = vm.mealsList.size,
            ) { position ->
                MealCard(
                    meal = vm.mealsList[position],
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )

            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MealCard(meal: MealItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GlideImage(
                model = meal.imgUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.img_size))
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
                transition = CrossFade
            )
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            Column {
                Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.displayMedium,
                    maxLines = 1,
                )

                Text(
                    text = meal.description,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealTopAppBar(modifier: Modifier = Modifier) {

    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.meals_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.img_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun MainContentPreview() {
    MealCard(
        meal = MealItem(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_large))
    )
}