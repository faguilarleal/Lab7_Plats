package com.androidfrancis.lab6.ui.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.ui.TopBar.TopBar
import com.androidfrancis.lab6.ui.profile.view.NavigationState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavHostController) {
    val scrollState= rememberScrollState()
    Column(
        Modifier
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())

    ){

        TopAppBar(

            colors = TopAppBarDefaults.largeTopAppBarColors(

                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(route = NavigationState.Concerts.route) {popUpTo(route = NavigationState.Detail.route){ inclusive = true } } })
            {Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "goback")}
            },

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
            },
            title = { Text(text = "Todo Eventos" ) }


        )
        Box(
            Modifier
            .fillMaxWidth()
            .height(210.dp)
            .background(Color.LightGray)
        ){

            Column(modifier = Modifier.padding(top = 180.dp, bottom = 2.dp,start=10.dp)){
                Text(text = "Lugar:", fontSize = 15.sp)
            }
        }
        Text("Alemania",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontWeight= FontWeight.Bold, fontSize = 25.sp)
        Row(){
            Icon(modifier= Modifier
                .size(55.dp)
                .padding(15.dp)
                ,painter = painterResource(id = R.drawable.ic_calendario),
                contentDescription = "")
            Text("Fecha",
                Modifier.padding(5.dp).weight(5.0f),
                fontSize = 15.sp)
            Text("Hora",
                Modifier.padding(5.dp).weight(1.0f),
                fontSize = 15.sp,
            )
        }
        Column(){
            Text("About",
                Modifier.padding(10.dp),
                fontWeight= FontWeight.Bold,
                fontSize = 20.sp)
            Text("Aqui va informacion importante sobre muchas cosas no se que hacer ni que escribir bla bla bla ",
                Modifier.padding(start=10.dp),
                fontSize = 15.sp,
            )
        }
        Row(
            modifier = Modifier.padding(top= 170.dp,start = 85.dp),
            verticalAlignment = Alignment.Bottom,

            ) {
            Button(onClick = { /*TODO*/ },

                modifier= Modifier.padding(5.dp)) {
                Text("Favorite")
            }
            Spacer(modifier = Modifier.width(40.dp))

            Button(onClick = { /*TODO*/ }, modifier= Modifier.padding(5.dp)) {
                Text("Buy")
            }
        }
    }
}



