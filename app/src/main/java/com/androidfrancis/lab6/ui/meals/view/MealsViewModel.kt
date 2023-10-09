package com.androidfrancis.lab6.ui.meals.view

import androidx.lifecycle.ViewModel
import com.androidfrancis.lab6.networking.response.FilterListResponse
import com.androidfrancis.lab6.ui.meals.repository.MealsRepository

class MealsViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel(){
    fun getMeals(successCallback: (response: FilterListResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}