package com.route.mealsapp.repository

import com.route.mealsapp.model.MealItem

interface Repository {
    suspend fun getMeals(): List<MealItem>
}

interface OnlineMeals {
    suspend fun isOnline(): Boolean
    suspend fun getMeals(): List<MealItem>
}

interface OfflineMeals {
    suspend fun getMeals(): List<MealItem>
    suspend fun saveMeals(mealsList: List<MealItem>)
}