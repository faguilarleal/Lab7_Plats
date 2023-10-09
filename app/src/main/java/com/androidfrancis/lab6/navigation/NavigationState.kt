package com.androidfrancis.lab6.ui.profile.view

sealed class NavigationState(val route: String) {
    object Home: NavigationState("Home")
    object Concerts: NavigationState("Concerts")
    object Detail: NavigationState("Detail")
    object Profile: NavigationState("Profile")
    object Favorites: NavigationState("Favorites")
    object Favorite2: NavigationState("Favorite2")
}