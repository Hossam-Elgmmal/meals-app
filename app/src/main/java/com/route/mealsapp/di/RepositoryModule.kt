package com.route.mealsapp.di

import com.route.mealsapp.repository.OfflineMeals
import com.route.mealsapp.repository.OfflineMealsImpl
import com.route.mealsapp.repository.OnlineMeals
import com.route.mealsapp.repository.OnlineMealsImpl
import com.route.mealsapp.repository.Repository
import com.route.mealsapp.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository {
        return impl
    }

    @Singleton
    @Provides
    fun provideOnlineMeals(impl: OnlineMealsImpl): OnlineMeals {
        return impl
    }

    @Singleton
    @Provides
    fun provideOfflineMeals(impl: OfflineMealsImpl): OfflineMeals {
        return impl
    }
}