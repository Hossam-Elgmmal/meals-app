package com.route.mealsapp.model

import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): Meals
}