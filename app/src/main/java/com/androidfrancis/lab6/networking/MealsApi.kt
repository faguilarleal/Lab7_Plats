package com.androidfrancis.lab6.networking

import com.androidfrancis.lab6.networking.response.FilterListResponse
import com.androidfrancis.lab6.networking.response.LookupListResponse
import com.androidfrancis.lab6.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {

    // obtener las categorias
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>

    @GET("filter.php?c=Seafood")
    fun getFilter(): Call<FilterListResponse>

    @GET("lookup.php?i=52944")
    fun getLookup(): Call<LookupListResponse>
}