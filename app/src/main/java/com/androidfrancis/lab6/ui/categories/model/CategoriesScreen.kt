package com.androidfrancis.lab6.ui.categories.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.androidfrancis.lab6.navigation.NavigationMeals
import com.androidfrancis.lab6.networking.response.FilterResponse

import com.androidfrancis.lab6.networking.response.MealResponse
import com.androidfrancis.lab6.networking.response.MealsCategoriesResponse
import com.androidfrancis.lab6.ui.categories.view.CategoriesViewModel


@Composable
fun CategoriesScreen(navController: NavHostController) {
    val viewModel: CategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getCategories { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }
    Column(){
        LazyColumn {

            items(rememberedMeals.value) { meal ->
                Cards(meal, navController)
            }
        }
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(pmeal: MealResponse, navController: NavHostController){

    Card(
        onClick = {navController.navigate(route = NavigationMeals.Meals.route)},
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Row(){
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
            Column() {
                Text(
                    modifier= Modifier
                        .padding(top = 15.dp),
                    text = pmeal.name, fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier= Modifier
                        .padding(top = 15.dp),
                    text = pmeal.description, fontSize = 15.sp,
                )
            }


        }
    }
}


