package com.androidfrancis.lab6.ui.mealDetail.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
                Cards(meal)
            }
        }
    }
}

@Composable
fun Cards(pmeal: LookupResponse){
    Card(){
        Column(){
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            ){

                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data(pmeal.imgURL)
                    .transformations()
                    .build()
                    ,
                    contentDescription = "",
                    modifier= Modifier.fillMaxSize())
            }
            Row(){
                Text(
                    text = "Area", fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = pmeal.area
                )
            }
            Text(
                text = "Ingredientes: ", fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            // ingredientes
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = pmeal.ingredient1
            )
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = pmeal.ingredient2
            )
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = pmeal.ingredient3
            )
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = pmeal.ingredient4
            )



            // instrucciones
            Text(
                text = "Instrucciones: ", fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = pmeal.instructions
            )

        }

    }

}

