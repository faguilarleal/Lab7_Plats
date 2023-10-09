package com.androidfrancis.lab6.networking
import com.androidfrancis.lab6.networking.response.FilterListResponse
import com.androidfrancis.lab6.networking.response.LookupListResponse
import com.androidfrancis.lab6.networking.response.MealsCategoriesResponse
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

class MealsWebServices {
    // gestion del llamado de la api, interactuar con ella


    // obtiene la api
    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/") // ?
            .addConverterFactory(GsonConverterFactory.create()) // recibir Json y conversion a objetos kotlin
            .build()

        api = retrofit.create(MealsApi::class.java) // instancia de la interfaz MealsApi
    }

    fun getMeals(): Call<MealsCategoriesResponse> {
        // devuelve la llamada call
        return api.getMeals()
    }

    fun getFilters(): Call<FilterListResponse> {
        return api.getFilter()
    }

    fun getLookUps(): Call<LookupListResponse> {
        return api.getLookup()
    }


}