package com.androidfrancis.lab6.ui.TopBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.ui.profile.view.NavigationState

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(navController: NavHostController){

    TopAppBar(

        colors = TopAppBarDefaults.largeTopAppBarColors(

            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),


        actions = {
            IconButton(onClick = { navController.navigate(route = NavigationState.Profile.route)  }) {
                Icon(painter = painterResource(id = R.drawable.ic_usuario2), contentDescription = "")
            }

            IconButton(onClick = { /*TODO*/ navController.navigate(route = NavigationState.Favorites.route) }) {
                Icon(painter = painterResource(id = R.drawable.ic_estrella), contentDescription = "date")
            }
            IconButton(onClick = { /*TODO*/ navController.navigate(route = NavigationState.Concerts.route) }) {
                Icon(painter = painterResource(id = R.drawable.ic_icono1), contentDescription = "AccountCircle")
            }
            IconButton(onClick = { /*TODO*/ navController.navigate(route = NavigationState.Favorite2.route) }) {
                Icon(painter = painterResource(id = R.drawable.ic_favorito), contentDescription = "AccountCircle")
            }
        },
        title = { Text(text = "Todo Eventos" ) }


    )
}
