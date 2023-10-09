package com.androidfrancis.lab6.ui.concerts.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsStartWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.ui.TopBar.TopBar
import com.androidfrancis.lab6.ui.profile.view.NavigationState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConcertsView(navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())

    ){


        TopBar(navController);
//
//            colors = TopAppBarDefaults.largeTopAppBarColors(
//
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                titleContentColor = MaterialTheme.colorScheme.primary,
//            ),
//            title = {
//                Text("TodoEventos", fontWeight = FontWeight.Bold,)
//            },
//            actions = {
//                IconButton(onClick = { /* do something */ }) {
//                    Icon(painter = painterResource(id = R.drawable.ic_tres_puntos), contentDescription = "")
//                }
//            }
//
//        )
        Text(
            "Your Favorites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)

        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)



        ) {
            Cards(Images(R.drawable.ic_img1, "Party", "Snoopy en una fiesta"), navController)
            Cards(Images(R.drawable.ic_img2, "Risa", "Snoopy Riendose"), navController)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)


        ) {
            Cards(Images(R.drawable.ic_img3, "Libreria", "Snoopy en la libreria"), navController)
            Cards(Images(R.drawable.ic_img4, "Supermercado", "Snoopy gritando en el supermercado"), navController)
        }
        Text(
            "All images",
            fontSize = 25.sp,
            modifier = Modifier
                .padding(10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)


        ) {
            Cards(Images(R.drawable.ic_img1, "Party", "Snoopy en una fiesta"),navController)
            Cards(Images(R.drawable.ic_img2, "Risa", "Snoopy Riendose"), navController)
        }

    }


}

data class Images(var img: Int, var txt1 : String, var txt2 : String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards( p: Images, navController: NavHostController){

    Card(
        onClick = {navController.navigate(route = NavigationState.Detail.route)},
        modifier = Modifier
            .padding(10.dp)
            .width(160.dp) // Establece el ancho deseado
            .height(230.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .width(160.dp)
                    .height(100.dp)
            ){
                Image(
                    painter = painterResource(id = p.img),
                    contentDescription = stringResource(id = R.string.d1),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }


            Text(
                text = p.txt1, fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                modifier = Modifier
                    .padding(5.dp),
                text = p.txt2
            )
        }
    }
}


