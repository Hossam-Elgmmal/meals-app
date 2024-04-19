package com.route.mealsapp

import android.app.Application
import com.route.mealsapp.database.MealDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MealsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MealDatabase.init(this)
    }
}