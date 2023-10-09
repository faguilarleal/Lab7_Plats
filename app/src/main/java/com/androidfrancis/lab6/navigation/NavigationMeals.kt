package com.androidfrancis.lab6.navigation

sealed class NavigationMeals(val route: String) {
    object Meals: NavigationMeals("Meals")
    object MealsDetail: NavigationMeals("MealsDetail")
    object Categories: NavigationMeals("Categories")
}