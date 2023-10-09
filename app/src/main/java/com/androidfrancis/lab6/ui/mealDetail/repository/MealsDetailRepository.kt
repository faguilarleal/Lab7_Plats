package com.androidfrancis.lab6.ui.mealDetail.repository

import com.androidfrancis.lab6.networking.MealsWebServices
import com.androidfrancis.lab6.networking.response.FilterListResponse
import com.androidfrancis.lab6.networking.response.LookupListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsDetailRepository (private val webService: MealsWebServices = MealsWebServices()){
    fun getDetails(successCallback: (response: LookupListResponse?) -> Unit) {
        return webService.getLookUps().enqueue(object : Callback<LookupListResponse> {
            override fun onResponse(
                call: Call<LookupListResponse>,
                response: Response<LookupListResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }
            override fun onFailure(call: Call<LookupListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}


