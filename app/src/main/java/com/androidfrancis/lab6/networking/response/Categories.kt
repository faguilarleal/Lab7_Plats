package com.androidfrancis.lab6.networking.response

import com.google.gson.annotations.SerializedName

//  lista de las categorias
data class MealsCategoriesResponse(val categories: List<MealResponse>)


// cada una de las categorias tiene un id, name, descripcion, imagen
data class MealResponse(
    @SerializedName("idCategory") val id: String, // el serialized name es para evitar errores de la api creo xd
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)