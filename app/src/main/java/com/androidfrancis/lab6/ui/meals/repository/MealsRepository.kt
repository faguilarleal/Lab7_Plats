package com.androidfrancis.lab6.ui.meals.repository

import com.androidfrancis.lab6.networking.MealsWebServices
import com.androidfrancis.lab6.networking.response.FilterListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebServices = MealsWebServices()) {
    fun getMeals(successCallback: (response: FilterListResponse?) -> Unit) {
        return webService.getFilters().enqueue(object : Callback<FilterListResponse> {
            override fun onResponse(
                call: Call<FilterListResponse>,
                response: Response<FilterListResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
                //Log.i(ContentValues.TAG, "funciona :)")
            }
            override fun onFailure(call: Call<FilterListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

