package com.route.mealsapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.mealsapp.model.MealItem
import com.route.mealsapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mealsRepository: Repository
) : ViewModel() {

    val mealsList = mutableStateListOf<MealItem>()

    fun getMeals() {
        viewModelScope.launch(Dispatchers.IO) {
            mealsList.addAll(mealsRepository.getMeals())
        }
    }
}