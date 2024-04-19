package com.route.mealsapp.repository

import android.util.Log
import com.route.mealsapp.database.MealsDao
import com.route.mealsapp.model.MealItem
import com.route.mealsapp.model.MealsApi
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val onlineMeals: OnlineMeals,
    private val offlineMeals: OfflineMeals,
) : Repository {
    override suspend fun getMeals(): List<MealItem> {
        if (onlineMeals.isOnline()) {
            try {
                val mealsList = onlineMeals.getMeals()
                offlineMeals.saveMeals(mealsList)
                return mealsList
            } catch (e: Exception) {
                Log.e("TAG", "getMeals: ${e.message}", e)
            }
        }
        return offlineMeals.getMeals()
    }
}

class OnlineMealsImpl @Inject constructor(private val mealsApi: MealsApi) : OnlineMeals {
    override suspend fun isOnline(): Boolean {
        return true
    }

    override suspend fun getMeals(): List<MealItem> {
        return mealsApi.getMeals().mealsList
    }
}

class OfflineMealsImpl @Inject constructor(
    private val mealsDao: MealsDao
) : OfflineMeals {
    override suspend fun getMeals(): List<MealItem> {
        return mealsDao.getMeals()
    }

    override suspend fun saveMeals(mealsList: List<MealItem>) {
        mealsDao.saveMeals(mealsList)
    }
}