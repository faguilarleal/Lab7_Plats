package com.androidfrancis.lab6.ui.profile.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidfrancis.lab6.navigation.NavigationMeals
import com.androidfrancis.lab6.ui.categories.model.CategoriesScreen
import com.androidfrancis.lab6.ui.concerts.view.ConcertsView

import com.androidfrancis.lab6.ui.detail.view.DetailView
import com.androidfrancis.lab6.ui.favorites.view.Favorites2View
import com.androidfrancis.lab6.ui.favorites.view.favoritesView
import com.androidfrancis.lab6.ui.mealDetail.model.MealsDetailScreen
import com.androidfrancis.lab6.ui.meals.model.MealsScreen

@Preview(showBackground = true, showSystemUi = true)
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun ANavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationState.Concerts.route ) {
        composable(route = NavigationState.Profile.route ){
            profileView(navController)
        }
        composable(route = NavigationState.Concerts.route ){
            ConcertsView(navController)
        }
        composable(route = NavigationState.Favorites.route ){
            favoritesView(navController)
        }
        composable(route = NavigationState.Detail.route ){
            DetailView(navController)
        }
        composable(route = NavigationState.Favorite2.route ){
            Favorites2View(navController)
        }
    }


}

@Composable
fun BNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationMeals.Categories.route ) {
        composable(route = NavigationMeals.Meals.route  ){
            MealsScreen(navController)
       }
        composable(route = NavigationMeals.Categories.route  ){
            CategoriesScreen(navController)
        }
        composable(route = NavigationMeals.MealsDetail.route  ){
            MealsDetailScreen(navController)
        }
    }
}