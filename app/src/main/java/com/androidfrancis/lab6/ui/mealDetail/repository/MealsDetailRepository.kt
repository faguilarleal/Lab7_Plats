package com.androidfrancis.lab6.ui.meals.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.androidfrancis.lab6.networking.MealsWebServices
import com.androidfrancis.lab6.networking.response.LookupListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsDetailRepository(private val webService: MealsWebServices = MealsWebServices()) {
    fun getDetails(successCallback: (response: LookupListResponse?) -> Unit) {
        return webService.getDetails().enqueue(object : Callback<LookupListResponse> {
            override fun onResponse(
                call: Call<LookupListResponse>,
                response: Response<LookupListResponse>
            ) {
                if (response.isSuccessful){
                    successCallback(response.body())
                    Log.i(TAG, "funciona :)")
                }else{
                    Log.e(TAG, "Error >:(")
                }

            }
            override fun onFailure(call: Call<LookupListResponse>, t: Throwable) {
                Log.e(TAG, "Error")
            }
        })
    }
}

