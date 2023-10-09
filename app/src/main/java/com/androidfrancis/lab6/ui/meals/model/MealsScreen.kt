package com.androidfrancis.lab6.ui.meals.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.networking.response.FilterResponse
import com.androidfrancis.lab6.ui.concerts.view.Images
import com.androidfrancis.lab6.ui.meals.view.MealsViewModel
import com.androidfrancis.lab6.ui.profile.view.NavigationState

@Composable
fun MealsScreen(navController: NavHostController) {
    val viewModel: MealsViewModel = viewModel()
    val rememberedMeals: MutableState<List<FilterResponse>> = remember { mutableStateOf(emptyList<FilterResponse>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }
    Column(){
        LazyColumn {

            items(rememberedMeals.value) { meal ->
                Cards(meal)
            }
        }
    }



}



@Composable
fun Cards(pmeal: FilterResponse){

    Card(
       // onClick = {navController.navigate(route = NavigationState.Detail.route)},
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

                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data(pmeal.imageUrl)
                    .transformations()
                    .build()
                    ,
                    contentDescription = "",
                    modifier= Modifier.fillMaxWidth())
            }

            Text(
                text = pmeal.name, fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )

        }
    }
}


