package com.androidfrancis.lab6.ui.favorites.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.ui.TopBar.TopBar
import com.androidfrancis.lab6.ui.theme.Lab6Theme



@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun favoritesView(navController: NavHostController){
    val scrollState= rememberScrollState()
    Column(){
        TopBar(navController);
        CardsH("Guns and Roses LA", "LA Hall")
        CardsH("Guns and Roses Denver", "Denver Hall")
        CardsH("Guns and Roses New York", "Maddison Square Garden")

    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun CardsH(cancion: String, autor: String){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(100.dp)
    ){
        Column(
            modifier = Modifier
                .padding(10.dp)
                .height(100.dp)
        )
        {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 10.dp,),
                verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = { /* do something */ },
                    Modifier
                        .padding(15.dp),
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_icono2), contentDescription = "")
                }
                Row(Modifier
                    .weight(5.0f)){
                    Text(
                        buildAnnotatedString {
                            append(cancion+"\n")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)
                            ) {
                                append(autor)
                            }
                        }
                    )
                }


                IconButton(onClick = { /* do something */ },

                    Modifier
                        .weight(2.0f)
                        .requiredHeight(20.dp),
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_icono1), contentDescription = "")
                }

            }
        }
    }
}




