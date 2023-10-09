package com.androidfrancis.lab6.ui.categories.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

import com.androidfrancis.lab6.networking.response.MealResponse
import com.androidfrancis.lab6.ui.categories.view.CategoriesViewModel


@Composable
fun CategoriesScreen(navController: NavHostController) {
    val viewModel: CategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getCategories { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }
    Column(){
        LazyColumn {

            items(rememberedMeals.value) { meal ->
                //Cards(meal)
            }
        }
    }



}