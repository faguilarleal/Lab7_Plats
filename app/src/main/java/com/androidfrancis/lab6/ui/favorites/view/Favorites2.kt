package com.androidfrancis.lab6.ui.favorites.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.ui.TopBar.TopBar

@Composable
fun Favorites2View(navController: NavHostController){

    val canciones = listOf(
        "Bohemian Rhapsody - Queen",
        "Imagine - John Lennon",
        "Hotel California - Eagles",
        "Like a Rolling Stone - Bob Dylan",
        "Billie Jean - Michael Jackson",
        "Yesterday - The Beatles",
        "Stairway to Heaven - Led Zeppelin",
        "Smells Like Teen Spirit - Nirvana",
        "Purple Haze - Jimi Hendrix",
        "I Want to Hold Your Hand - The Beatles",
        "Hey Jude - The Beatles",
        "Thriller - Michael Jackson",
        "Sweet Child o' Mine - Guns N' Roses",
        "Let It Be - The Beatles",
        "Boogie Wonderland - Earth, Wind & Fire"
    )
    Column(){
        TopBar(navController);
        ListWithColumn(canciones)
    }
}

@Composable
fun ListWithColumn(items: List<String>) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) { // (2)
        items.forEach { item ->

            ListItemRow(item)
        }
    }
}

@Composable
fun ListItemRow(item: String, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),

    ) {IconButton(onClick = { /* do something */ },
        Modifier
            .size(20.dp)
            .padding(5.dp),
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_favorito), contentDescription = "")
    }
        Text(text = item)
    }
}