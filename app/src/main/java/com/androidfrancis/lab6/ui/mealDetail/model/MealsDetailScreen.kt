package com.androidfrancis.lab6.ui.mealDetail.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.networking.response.LookupResponse
import com.androidfrancis.lab6.ui.mealDetail.view.MealsDetailViewModel


@Composable
fun MealsDetailScreen(navController: NavHostController) {
    val viewModel: MealsDetailViewModel = viewModel()
    val rememberedMeals: MutableState<List<LookupResponse>> = remember { mutableStateOf(emptyList<LookupResponse>()) }

    viewModel.getDetails { response ->
        val mealsFromTheApi = response?.mealsDetail
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