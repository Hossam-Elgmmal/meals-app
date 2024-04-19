package com.route.mealsapp.di

import com.route.mealsapp.database.MealDatabase
import com.route.mealsapp.database.MealsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDao(): MealsDao {
        return MealDatabase.getInstance().getDao()
    }
}