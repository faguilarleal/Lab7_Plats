package com.androidfrancis.lab6.ui.mealDetail.view

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.androidfrancis.lab6.networking.response.LookupListResponse
import com.androidfrancis.lab6.ui.meals.repository.MealsDetailRepository

class MealsDetailViewModel(private val repository: MealsDetailRepository = MealsDetailRepository()): ViewModel() {
    fun getDetails(successCallback: (response: LookupListResponse?) -> Unit) {
        repository.getDetails { response ->
            if (response != null) {
                Log.i(TAG, "funciona :o")
                //Log.i(TAG, response.mealsDetail.toString())
                successCallback(response)
            } else {
                Log.e(TAG, "Error :o")
                // Aquí puedes manejar el caso en que la respuesta sea null
            }
        }
    }
}