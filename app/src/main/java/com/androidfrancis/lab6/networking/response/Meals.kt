package com.androidfrancis.lab6.networking.response

import com.google.gson.annotations.SerializedName

data class FilterListResponse(val meals: List<FilterResponse>)

data class FilterResponse(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String
)