package com.androidfrancis.lab6.ui.categories.view

import androidx.lifecycle.ViewModel
import com.androidfrancis.lab6.networking.response.MealsCategoriesResponse
import com.androidfrancis.lab6.ui.categories.repository.CategoriesRepository


class CategoriesViewModel (private val repository: CategoriesRepository = CategoriesRepository()): ViewModel(){
    fun getCategories(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getCategories { response ->
            successCallback(response)
        }
    }
}