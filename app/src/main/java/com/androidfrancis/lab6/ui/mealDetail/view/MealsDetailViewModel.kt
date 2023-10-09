package com.androidfrancis.lab6.ui.mealDetail.view

import androidx.lifecycle.ViewModel
import com.androidfrancis.lab6.networking.response.LookupListResponse
import com.androidfrancis.lab6.ui.mealDetail.repository.MealsDetailRepository

class MealsDetailViewModel(private val repository: MealsDetailRepository = MealsDetailRepository()): ViewModel() {
    fun getDetails(successCallback: (response: LookupListResponse?) -> Unit) {
        repository.getDetails { response ->
            successCallback(response)
        }
    }
}