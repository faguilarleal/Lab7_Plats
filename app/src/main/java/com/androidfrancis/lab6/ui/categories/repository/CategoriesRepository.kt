package com.androidfrancis.lab6.ui.categories.repository

import com.androidfrancis.lab6.networking.MealsWebServices
import com.androidfrancis.lab6.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesRepository(private val webService: MealsWebServices = MealsWebServices()) {
        fun getCategories(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
            return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {
                override fun onResponse(
                    call: Call<MealsCategoriesResponse>,
                    response: Response<MealsCategoriesResponse>
                ) {
                    if (response.isSuccessful)
                        successCallback(response.body())
                }

                override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
}
