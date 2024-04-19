package com.route.mealsapp.model

import com.google.gson.annotations.SerializedName

data class Meals(
    @SerializedName("categories")
    val mealsList: List<MealItem> = emptyList()
)
