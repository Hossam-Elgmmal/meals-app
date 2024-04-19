package com.route.mealsapp.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.route.mealsapp.model.MealItem

@Dao
interface MealsDao {
    @Upsert
    suspend fun saveMeals(mealsList: List<MealItem>)

    @Query("select * from mealitem")
    suspend fun getMeals(): List<MealItem>
}