package com.route.mealsapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.route.mealsapp.model.MealItem
import com.route.mealsapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mealsRepository: Repository
) : ViewModel() {

    val mealsList = mutableStateListOf<MealItem>()

    suspend fun getMeals() {
        mealsList.addAll(mealsRepository.getMeals())
    }
}